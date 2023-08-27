package com.example.trainer_app.data.models

import com.squareup.moshi.Json


data class Credentials(
    @field:Json(name = "email")
    val email: String,
    @field:Json(name = "password")
    val password: String,
    @field:Json(name = "device_name")
    val deviceName: String
)

data class UserAble(
    val username: String,
    val name: String,
    val email: String,
    val password: String,
    @field:Json(name="userable_type")
    val userableType: String,
    var cref: String? = "",
    var graduation_year: String? ="",
    var institution: String? = "",
    val birthday: String,
    val image: String = "",
    val description: String = ""
)

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val name: String,
    @field:Json(name="userable_type")
    val userableType: String,
    val userable_id: Int,
    val cref: String?,
    val graduation_year: String?,
    val institution: String?,
    val birthday: String,
    val image: String = "",
    val description: String = ""

)
