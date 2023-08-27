package com.example.trainer_app.views.theme

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.trainer_app.views.theme.trainericonpack.Exercise
import com.example.trainer_app.views.theme.trainericonpack.Home
import com.example.trainer_app.views.theme.trainericonpack.Profile
import com.example.trainer_app.views.theme.trainericonpack.Programs
import com.example.trainer_app.views.theme.trainericonpack.Reports
import kotlin.collections.List as ____KtList

public object TrainerIconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val TrainerIconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Home, Programs, Reports, Profile, Exercise)
    return __AllIcons!!
  }
