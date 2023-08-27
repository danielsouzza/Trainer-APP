package com.example.trainer_app.views.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trainer_app.views.screen.ExercisesScreen
import com.example.trainer_app.views.screen.HomeScreen
import com.example.trainer_app.views.screen.ProfileScreen
import com.example.trainer_app.views.screen.ProgramsScreen
import com.example.trainer_app.views.screen.ReportScreen
import com.example.trainer_app.views.view_model.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavGraph(navController: NavHostController,viewModel: MainViewModel){
    NavHost(
        navController = navController,
        startDestination= BottomBarScreen.Programs.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Programs.route){
            ProgramsScreen()
        }
        composable(route = BottomBarScreen.Exercises.route){
            ExercisesScreen(viewModel)
        }
        composable(route = BottomBarScreen.Report.route){
            ReportScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
    }
}