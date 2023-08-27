package com.example.trainer_app.views.view_model

import retrofit2.Response
import java.lang.Exception

interface ViewModelsCallback<T> {

    fun onResponse(response: T)

    fun onFail(response: Throwable)
}