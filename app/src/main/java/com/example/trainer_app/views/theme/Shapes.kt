package com.example.trainer_app.views.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(20.dp),
    medium = RoundedCornerShape(25.dp),
    large = RoundedCornerShape(60.dp),
    extraLarge = RoundedCornerShape(100.dp)
)

val ShapesCards = Shapes(
    medium = RoundedCornerShape(25.dp),
    large = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp, bottomEnd = 0.dp, bottomStart = 0.dp)
)