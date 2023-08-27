package com.example.trainer_app.views.screen



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.trainer_app.R
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.ContainerButton
import com.example.trainer_app.views.theme.Secondary
import com.example.trainer_app.views.components.InputText
import com.example.trainer_app.views.theme.Black90
import com.example.trainer_app.views.theme.Purple80
import com.example.trainer_app.views.view_model.LoginViewModel

@Composable
fun Login(
    viewModel: LoginViewModel,
    navController: NavHostController,
){
    val progressState by viewModel.progressBar.collectAsState()

    Box(modifier = Modifier.fillMaxSize()){
        if(progressState) {
            Box(
                Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .zIndex(999f)
                    .background(Black90)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Purple80
                )

            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier= Modifier
                .fillMaxSize()
                .background(color = Background)
        ) {
            Spacer(modifier = Modifier.height(90.dp))

            Image(
                painter = painterResource(R.drawable.login),
                contentDescription = "Image",
            )

            Spacer(modifier = Modifier.height(60.dp))

            val emailState = rememberSaveable {
                mutableStateOf("")
            }
            val passwordState = rememberSaveable {
                mutableStateOf("")
            }
            InputText(
                valueState = emailState.value,
                stringHint = stringResource(id = R.string.email_hint),
                leadingIcon = Icons.Default.Email
            ){
                emailState.value = it
            }
            InputText(
                valueState = passwordState.value,
                stringHint = stringResource(id = R.string.password_hint),
                leadingIcon = Icons.Default.Lock
            ){
                passwordState.value = it
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    viewModel.auth(emailState.value,passwordState.value)

                },
                colors= ButtonDefaults.buttonColors(
                    containerColor = ContainerButton,
                ),
                modifier = Modifier
                    .width(250.dp)
                    .height(45.dp)
            ) {
                Text(
                    text = stringResource(R.string.enter),
                    fontSize = 18.sp)
            }


            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate("register")
                },
                colors= ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Secondary
                ),
                modifier = Modifier
                    .width(250.dp)
                    .height(34.dp)
            ) {
                Text(
                    text = stringResource(R.string.create_account),
                    fontSize = 14.sp)
            }
        }
    }
}
