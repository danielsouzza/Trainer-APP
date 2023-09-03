package com.example.trainer_app.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.R
import com.example.trainer_app.views.theme.Primary_1
import com.example.trainer_app.views.theme.Shapes
import com.example.trainer_app.views.view_model.CreateProgramViewModel

@Composable
fun SelectedStudentCard(
    viewModel: CreateProgramViewModel,
    onClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val userSelected by viewModel.studentSelected.collectAsState()


    Column(
        modifier = Modifier
    ) {
        Button(
            onClick = { onClick() },
            shape = Shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary_1
            ),
            contentPadding = PaddingValues(
                start = 20.dp,
                bottom = 5.dp,
                top=5.dp,
                end = 2.dp
            ),
            modifier = Modifier.height(60.dp)
        ) {
            BasicTextField(
                value = userSelected.name,
                onValueChange = { },
                readOnly = true,
                enabled = false,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight(600)
                ),
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "",
            )
        }
    }
}