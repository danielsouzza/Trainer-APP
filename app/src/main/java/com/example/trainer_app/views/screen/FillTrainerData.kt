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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.R
import com.example.trainer_app.views.components.InfoRegisterScreen
import com.example.trainer_app.views.components.InputText
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.theme.Secondary
import com.example.trainer_app.views.view_model.RegisterViewModel


@Composable
fun FillTrainerData(
    viewModel: RegisterViewModel,
    onNavigate: () -> Unit
) {
    viewModel.changeInfoScreen(InfoRegisterScreen.FillTrainer)
    val fullNameState = rememberSaveable {
        mutableStateOf("")
    }
    val crefState = rememberSaveable {
        mutableStateOf("")
    }
    val institutionState = rememberSaveable {
        mutableStateOf("")
    }

    val birthdayState = rememberSaveable {
        mutableStateOf("")
    }

    val graduationYearState = rememberSaveable {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 20.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                InputText(
                    valueState = fullNameState.value,
                    stringHint = stringResource(id = R.string.fullname_hint),
                    leadingIcon = Icons.Default.AccountCircle,
                    onValueChange = { fullNameState.value = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputText(
                    valueState = crefState.value,
                    stringHint = stringResource(id = R.string.cref_hint),
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.wysiwyg),
                    onValueChange = { crefState.value = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputText(
                    valueState = institutionState.value,
                    stringHint = stringResource(id = R.string.institution_hint),
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.corporate),
                    onValueChange = { institutionState.value = it }
                )
                Spacer(modifier = Modifier.height(8.dp))

                InputText(
                    valueState = graduationYearState.value,
                    stringHint = stringResource(id = R.string.graduation_year_hint),
                    leadingIcon = Icons.Default.DateRange,
                    onValueChange = { graduationYearState.value = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                InputText(
                    valueState = birthdayState.value,
                    stringHint = stringResource(id = R.string.birthdayState_hint),
                    leadingIcon = Icons.Default.DateRange,
                    onValueChange = { birthdayState.value = it }
                )
            }
            Button(
                onClick = {

                    val validate: Boolean = (
                            fullNameState.value.isNotEmpty() &&
                                    institutionState.value.isNotEmpty() &&
                                    graduationYearState.value.isNotEmpty() &&
                                    birthdayState.value.isNotEmpty() &&
                                    crefState.value.isNotEmpty()
                            )

                    if (!validate) {
                        return@Button
                    }
                    viewModel.fillUserData(
                        mapOf(
                            "name" to fullNameState.value,
                            "cref" to crefState.value,
                            "institution" to institutionState.value,
                            "graduation_year" to graduationYearState.value,
                            "birthday" to birthdayState.value,

                        )
                    )
                    onNavigate()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary,
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