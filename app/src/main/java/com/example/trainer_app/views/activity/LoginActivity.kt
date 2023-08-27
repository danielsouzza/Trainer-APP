package com.example.trainer_app.views.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainer_app.data.PreferenceDataStore
import com.example.trainer_app.data.network.ApiService
import com.example.trainer_app.views.theme.TrainerappTheme
import com.example.trainer_app.views.screen.Login
import com.example.trainer_app.views.screen.RegisterScreen
import com.example.trainer_app.views.view_model.LoginViewModel
import com.example.trainer_app.views.view_model.RegisterViewModel

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel = LoginViewModel( PreferenceDataStore(this)){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        val registerViewModel: RegisterViewModel = RegisterViewModel(apiService = ApiService.providerRetrofit)

        setContent {

            TrainerappTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "login") {
                    composable("login") {
                        Login(viewModel = loginViewModel, navController = navController)
                    }
                    composable("register") {
                        RegisterScreen(viewModel = registerViewModel, navController = navController)
                    }
                }
            }
        }
    }
}