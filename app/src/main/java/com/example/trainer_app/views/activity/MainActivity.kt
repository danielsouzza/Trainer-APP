package com.example.trainer_app.views.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainer_app.data.PreferenceDataStore
import com.example.trainer_app.views.screen.CreateProgram
import com.example.trainer_app.views.screen.MainScreen
import com.example.trainer_app.views.theme.TrainerappTheme
import com.example.trainer_app.views.view_model.MainViewModel
import com.example.trainer_app.views.view_model.ProgramViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel = MainViewModel(PreferenceDataStore(this))
        val programViewModel = ProgramViewModel()
        setContent {
            TrainerappTheme {
                val mainNavController = rememberNavController()

                NavHost(mainNavController, startDestination = "main") {
                    composable("main") {
                        MainScreen(viewModel=mainViewModel, mainNavigator = mainNavController)
                    }
                    composable("register_program") {
                        CreateProgram(viewModel = programViewModel, navigator = mainNavController)
                    }

                    composable("choose_student"){

                    }
                }
            }
        }
    }
}
