package com.example.trainer_app.data.models

import com.squareup.moshi.Json

data class TrainingProgram(
    val name: String,
    val description: String,
    @field:Json(name="student_id")
    val studentID: Int,
    val weekdays: List<Int>,
    @field:Json(name="personal_id")
    val personalID: Int,
)
