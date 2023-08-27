package com.example.trainer_app.views.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trainer_app.views.screen.FillStudentData
import com.example.trainer_app.views.screen.FillTrainerData
import com.example.trainer_app.views.screen.FillUserContent
import com.example.trainer_app.views.screen.TypeUser
import com.example.trainer_app.views.view_model.RegisterViewModel

@Composable
fun RegisterNavGraph(
    viewModel: RegisterViewModel,
    navController: NavHostController,
    finishActivityAdapter: () -> Unit
){
    NavHost(navController = navController, startDestination = "type_user"){
        composable(route = "type_user"){
            TypeUser(viewModel){
                viewModel.setType(it)
                navController.navigate("fillUserData")
            }
        }

        composable(route= "fillUserData"){
            FillUserContent(viewModel){
                if(viewModel.getType() == "personal"){
                    navController.navigate("fillTrainerData")
                }else{
                    navController.navigate("fillStudentData")
                }
            }
        }

        composable(route="fillTrainerData"){
            FillTrainerData(viewModel = viewModel){
                viewModel.register()
                finishActivityAdapter()
            }
        }

        composable(route="fillStudentData"){
            FillStudentData(viewModel = viewModel){
                viewModel.register()
                finishActivityAdapter()
            }
        }
    }
}