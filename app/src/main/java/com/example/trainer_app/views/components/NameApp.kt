package com.example.trainer_app.views.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.R
import com.example.trainer_app.views.theme.Background_variant
import com.example.trainer_app.views.theme.Shapes

@Composable
fun NameApp(){
    Row (
        modifier = Modifier.fillMaxWidth().padding(0.dp,10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Surface(
            color= Background_variant,
            shape = Shapes.extraLarge,
            modifier = Modifier
                .size(120.dp,36.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                modifier= Modifier.padding(0.dp,5.dp),
                text = stringResource(id = R.string.name_app),
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                fontSize = 17.sp,
                fontWeight = FontWeight(500)
            )
        }
    }

}