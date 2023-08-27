package com.example.trainer_app.views.components

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.trainer_app.views.theme.TrainerIconPack
import com.example.trainer_app.views.theme.trainericonpack.Exercise
import com.example.trainer_app.views.theme.trainericonpack.Home
import com.example.trainer_app.views.theme.trainericonpack.Profile
import com.example.trainer_app.views.theme.trainericonpack.Programs
import com.example.trainer_app.views.theme.trainericonpack.Reports


sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,

    ){
    object Home: BottomBarScreen(
        route = "home",
        icon = TrainerIconPack.Home
    )
    object Programs: BottomBarScreen(
        route = "programs",
        icon = TrainerIconPack.Programs
    )
    object Exercises: BottomBarScreen(
        route = "exercises",
        icon = TrainerIconPack.Exercise

    )
    object Report: BottomBarScreen(
        route = "report",
        icon = TrainerIconPack.Reports

    )
    object Profile: BottomBarScreen(
        route = "profile",
        icon = TrainerIconPack.Profile

    )
}
