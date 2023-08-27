package com.example.trainer_app.views.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainer_app.data.PreferenceDataStore
import com.example.trainer_app.data.models.Auth
import com.example.trainer_app.data.models.User
import com.example.trainer_app.data.network.ApiService

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MainViewModel(
    private val dataStore: PreferenceDataStore,
): ViewModel(), ViewModelsCallback<User> {

    private val apiService = ApiService.providerRetrofit
    private val _user = MutableStateFlow(Auth.user)
    val user: StateFlow<User?> get() = _user

    init {
        viewModelScope.launch {
            try {
                val user = apiService.me()
                Auth.setUser(user)
                _user.value = Auth.user
                println(_user.value?.userableType)
            }catch (e: Throwable){
                println(e.message)
            }
        }
    }

    override fun onResponse(response: User) {
        TODO("Not yet implemented")
    }

    override fun onFail(response: Throwable) {
        TODO("Not yet implemented")
    }
}