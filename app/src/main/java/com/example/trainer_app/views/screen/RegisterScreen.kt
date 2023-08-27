package com.example.trainer_app.views.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainer_app.views.components.InfoRegisterScreen
import com.example.trainer_app.views.components.RegisterNavGraph
import com.example.trainer_app.views.components.SliderForm
import com.example.trainer_app.views.theme.BackWhite
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.Orange
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.theme.Secondary
import com.example.trainer_app.views.theme.ShapesCards
import com.example.trainer_app.views.theme.TextColor
import com.example.trainer_app.views.view_model.RegisterViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel,
    navController: NavHostController,
){
    val stepNavController = rememberNavController()
    val infoScreen by viewModel.infoScreen.collectAsState()
    Scaffold (
        topBar = { TopScreen(infoScreen) },
    ){
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            color = Background
        ) {
            RegisterNavGraph(viewModel = viewModel, navController = stepNavController){
                navController.popBackStack()
            }
        }
    }
}

@Composable
fun TopScreen(infoScreen: InfoRegisterScreen){
    Column (
        modifier = Modifier.background(Background)
    ){
        Surface (
            modifier= Modifier
                .background(Background)
                .padding(20.dp, 10.dp),
            color = BackWhite,
            shape = ShapesCards.medium
        ){
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    modifier= Modifier
                        .offset((-30).dp, 0.dp)
                        .size(30.dp),
                    imageVector= Icons.Default.ArrowBack,
                    contentDescription = "BackScreen",
                    tint = TextColor
                )
                Text(
                    text = stringResource(id = infoScreen.title),
                    color = TextColor,
                    fontWeight =  FontWeight(600),
                    fontSize = 18.sp
                )
            }
        }

        SliderForm(step=infoScreen.step)
    }
}
