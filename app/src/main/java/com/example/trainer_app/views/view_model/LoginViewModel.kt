package com.example.trainer_app.views.view_model


import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainer_app.data.PreferenceDataStore
import com.example.trainer_app.data.models.Credentials
import com.example.trainer_app.data.models.Token
import com.example.trainer_app.data.network.ApiController
import com.example.trainer_app.data.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoginViewModel(
    private val dataStore: PreferenceDataStore,
    val startHomeScreen: () -> Unit
): ViewModel(), ViewModelsCallback<Token>{

    private val apiController = ApiController(this)
    private val _progressBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val progressBar: StateFlow<Boolean> get() = _progressBar

    init {
        viewModelScope.launch {
            _progressBar.value = !_progressBar.value
            val token = dataStore.getToke()
            if(token != null){
                startHomeScreen()
                ApiService.setTokenProvider(Token(token))
            }else{
                _progressBar.value = !_progressBar.value
            }
        }
    }

    fun auth(email: String, password: String){
        val credentials = Credentials(email, password, Build.DEVICE)
        viewModelScope.launch {
            _progressBar.value = !_progressBar.value
            apiController.auth(credentials)
        }
    }

    override fun onResponse(response: Token) {
        _progressBar.value = !_progressBar.value
        if (response.accessToken.isNotEmpty()){
            viewModelScope.launch{
                dataStore.saveToken(response)
            }
            startHomeScreen()
        }
    }

    override fun onFail(response: Throwable) {
        _progressBar.value = !_progressBar.value
    }

}