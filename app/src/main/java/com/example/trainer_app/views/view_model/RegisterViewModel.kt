package com.example.trainer_app.views.view_model


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainer_app.data.models.UserAble
import com.example.trainer_app.data.network.ApiService
import com.example.trainer_app.views.components.InfoRegisterScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val apiService: ApiService
) : ViewModel(){

    private val _userdata = MutableStateFlow(mutableMapOf<String,String>())
    private var _usertype = ""


    private val _infoScreen: MutableStateFlow<InfoRegisterScreen> = MutableStateFlow(InfoRegisterScreen.TypeUser)
    val infoScreen: MutableStateFlow<InfoRegisterScreen> get() = _infoScreen

    fun changeInfoScreen(info: InfoRegisterScreen){
        _infoScreen.value = info
    }

    fun setType(type: String){
        _usertype = type
    }

    fun getType() = _usertype

    fun fillUserData(data: Map<String,String>){
        val updatedData = this._userdata.value.toMutableMap()
        updatedData.putAll(data)
        this._userdata.value = updatedData
    }


    fun register(){
        println(_userdata.value)
        val userData = UserAble(
            username = _userdata.value["username"]!!,
            name = _userdata.value["name"]!!,
            email = _userdata.value["email"]!!,
            password = _userdata.value["password"]!!,
            userableType= _usertype,
            birthday=_userdata.value["birthday"]!!,
        )
        if (_usertype == "personal"){
            userData.cref = _userdata.value["cref"]
            userData.institution = _userdata.value["institution"]
            userData.graduation_year = _userdata.value["graduation_year"]
        }
        viewModelScope.launch {
            try {
                apiService.createUser(userData)
            }catch (e: Exception){
                println(e.message)
            }
        }
    }
}