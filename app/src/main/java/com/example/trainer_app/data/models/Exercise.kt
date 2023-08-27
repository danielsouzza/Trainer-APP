package com.example.trainer_app.data.models

import com.squareup.moshi.Json

data class Exercise(
    val id: Int,
    val name : String,
    val thumbnail:String,
    @field:Json(name = "video_url")
    val videoUrl: String
)
