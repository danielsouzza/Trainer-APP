package com.example.trainer_app.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.views.theme.ButtonColors


@Composable
fun DefaultButton(
    text:String,
    colors: ButtonColors,
    onClick: ()-> Unit,

){
    Button(
        onClick = { onClick() },
        colors = colors,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                textAlign = TextAlign.Center,
            )
        )
    }
}



@Composable
@Preview
fun PreviewButton(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultButton(
            text = "SALVAR",
            ButtonColors()
        ) {

        }
    }

}