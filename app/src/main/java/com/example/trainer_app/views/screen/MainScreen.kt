package com.example.trainer_app.views.screen


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.trainer_app.views.components.BottomBarScreen
import com.example.trainer_app.views.components.MainNavGraph
import com.example.trainer_app.views.components.NameApp
import com.example.trainer_app.views.components.NavigationBar
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.view_model.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    mainNavigator: NavHostController
) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Exercises,
        BottomBarScreen.Programs,
        BottomBarScreen.Report,
        BottomBarScreen.Profile
    )
    val navController = rememberNavController()
    val user by viewModel.user.collectAsState()
    Scaffold(
        topBar = { NameApp() },
        bottomBar =  {
            NavigationBar(navController,screens)
        },
        floatingActionButton= {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val isProgramScreen = currentDestination?.hierarchy?.any {
                it.route == BottomBarScreen.Programs.route
            } == true

            val showButton =
                user?.userableType?.contains("PersonalTrainer")==true && isProgramScreen
            if(showButton){
                Button(onClick = {
                    mainNavigator.navigate("register_program")
                }) {
                    Text(text = "Novo")
                }
            }
        }

    ) {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(it)
        ){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(0.dp, 15.dp, 0.dp, 0.dp)
            ) {
                MainNavGraph(navController = navController, viewModel)
            }
        }
    }
}
