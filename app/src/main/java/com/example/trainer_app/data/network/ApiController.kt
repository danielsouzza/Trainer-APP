package com.example.trainer_app.data.network

import com.example.trainer_app.data.models.Credentials
import com.example.trainer_app.data.models.Token
import com.example.trainer_app.views.view_model.ViewModelsCallback


class ApiController (
    private val callback: ViewModelsCallback<Token>
) {
    private val apiService = ApiService.providerRetrofit

    suspend fun auth(credentials: Credentials) {
        try {
            val token = apiService.auth(credentials = credentials)
            if (token.accessToken.isNotEmpty()) {
                ApiService.setTokenProvider(token)
                callback.onResponse(token)
            } else {
                callback.onResponse(token)
            }
        }catch (e: Throwable){
            callback.onFail(e)
        }
    }

    suspend fun me(){
        try {
            val user = apiService.me()
            println(user)
        }catch (e: Throwable){
            callback.onFail(e)
        }
    }
}