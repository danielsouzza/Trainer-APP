package com.example.trainer_app.views.components

import com.example.trainer_app.R

sealed class InfoRegisterScreen(
    val route: String,
    val title: Int,
    val step: Float
){
    object TypeUser: InfoRegisterScreen(
        route = "type_user",
        title = R.string.choose_user,
        step = 1f
    )
    object FillUser: InfoRegisterScreen(
        route = "fillUserData",
        title = R.string.info_user,
        step = 2f
    )
    object FillStudent: InfoRegisterScreen(
        route = "fillStudentData",
        title = R.string.info_student,
        step = 3f
    )
    object FillTrainer: InfoRegisterScreen(
        route = "fillTrainerData",
        title = R.string.info_trainer,
        step = 3f
    )
}
