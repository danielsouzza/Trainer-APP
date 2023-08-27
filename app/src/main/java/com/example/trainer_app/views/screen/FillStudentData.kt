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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.R
import com.example.trainer_app.views.components.InfoRegisterScreen
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.components.SliderForm
import com.example.trainer_app.views.components.InputText
import com.example.trainer_app.views.view_model.RegisterViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FillStudentData(
    viewModel: RegisterViewModel,
    onclickAction: ()->Unit
){
    viewModel.changeInfoScreen(InfoRegisterScreen.FillStudent)
    val fullNameState = rememberSaveable {
        mutableStateOf("")
    }
    val birthdayState = rememberSaveable {
        mutableStateOf("")
    }

    val datePickerState = rememberDatePickerState()

    val showDatePickerDialog = remember {
        mutableStateOf(false)
    }

    val focusManager = LocalFocusManager.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color= Background
    ) {
        Column(
            modifier= Modifier.fillMaxHeight().padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(10.dp))

                InputText(
                    valueState = fullNameState.value,
                    stringHint = stringResource(id = R.string.fullname_hint),
                    leadingIcon = Icons.Default.AccountCircle,
                    onValueChange = { fullNameState.value = it }
                )

                Spacer(modifier = Modifier.height(8.dp))

                if(showDatePickerDialog.value){
                    DatePickerDialog(
                        onDismissRequest = { showDatePickerDialog.value = false},
                        confirmButton = {
                            Button(
                                onClick = {
                                    datePickerState
                                        .selectedDateMillis?.let { millis ->
                                            birthdayState.value = millis.toBrazilianDateFormat()
                                        }
                                    showDatePickerDialog.value = false
                                }
                            ) {
                                Text(text = "Escolher data")
                            }
                        }
                    ) {
                        DatePicker(
                            state = datePickerState,
                            colors = DatePickerDefaults.colors(
                                containerColor = Primary
                            )
                        )
                    }
                }

                InputText(
                    valueState = birthdayState.value,
                    stringHint = stringResource(id = R.string.birthdayState_hint),
                    leadingIcon = Icons.Default.DateRange,
                    onValueChange = {},
                    readOnly= true,
                    modifier = Modifier.onFocusEvent {
                        if(it.isFocused){
                            showDatePickerDialog.value = true
                            focusManager.clearFocus(force = true)
                        }
                    }
                )
            }

            Button(
                onClick = {
                          onclickAction()
                },
                colors= ButtonDefaults.buttonColors(
                    containerColor = Primary,
                ),
                modifier = Modifier
                    .width(250.dp)
                    .height(45.dp)
            ) {
                Text(
                    text = "Continuar",
                    fontSize = 18.sp)
            }
        }
    }
}

fun Long.toBrazilianDateFormat(
    pattern: String = "dd/MM/yyyy"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}