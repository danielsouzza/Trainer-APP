package com.example.trainer_app.views.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.R
import com.example.trainer_app.views.components.InfoRegisterScreen
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.Secondary
import com.example.trainer_app.views.components.SliderForm
import com.example.trainer_app.views.components.InputText
import com.example.trainer_app.views.view_model.RegisterViewModel


@Composable
fun FillUserContent(
    viewModel: RegisterViewModel,
    onclickAction: () -> Unit
){
    viewModel.changeInfoScreen(InfoRegisterScreen.FillUser)

    val usernameState = rememberSaveable {
        mutableStateOf("")
    }
    val emailState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordCheckState = rememberSaveable {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color= Background
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight().padding(vertical = 20.dp)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(10.dp))
                InputText(
                    valueState = usernameState.value,
                    stringHint = stringResource(id = R.string.username_hint),
                    leadingIcon = Icons.Default.AccountCircle,
                    onValueChange = { usernameState.value = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputText(
                    valueState = emailState.value,
                    stringHint = stringResource(id = R.string.email_hint),
                    leadingIcon = Icons.Default.Email,
                    onValueChange = { emailState.value = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputText(
                    valueState = passwordState.value,
                    stringHint = stringResource(id = R.string.password_hint),
                    leadingIcon = Icons.Default.Lock,
                    onValueChange = { passwordState.value = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputText(
                    valueState = passwordCheckState.value,
                    stringHint = stringResource(id = R.string.password_chek_hint),
                    leadingIcon = Icons.Default.Lock,
                    onValueChange = { passwordCheckState.value = it }
                )
            }

            Spacer(modifier = Modifier.height(100.dp))

            Button(
                onClick = {

                    val validate: Boolean = (
                            passwordState.value.isNotEmpty() &&
                            passwordCheckState.value.isNotEmpty() &&
                            emailState.value.isNotEmpty() &&
                            usernameState.value.isNotEmpty()
                    )

                    if (!validate){
                        return@Button
                    }
                    viewModel.fillUserData(
                        mapOf(
                            "username" to usernameState.value,
                            "email" to emailState.value,
                            "password" to passwordState.value,
                        )
                    )
                    onclickAction()
                },
                colors= ButtonDefaults.buttonColors(
                    containerColor = Secondary,
                ),
                modifier = Modifier
                    .width(250.dp)
                    .height(45.dp)
            ) {
                Text(
                    text = "Continuar",
                    fontSize = 18.sp
                )
            }
        }
    }
}