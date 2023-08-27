package com.example.trainer_app.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.trainer_app.views.theme.Shapes

@Composable
fun AppCard(
    image: Int,
    label: Int,
    color: Color,
    onClickAction: () -> Unit
){
    Surface (
        shape = Shapes.small
    ){
        Card(
            modifier = Modifier
                .size(150.dp, 130.dp)
                .clickable {
                    onClickAction()
                },
            colors = CardDefaults.cardColors(color),

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    modifier= Modifier
                        .size(90.dp, 90.dp)
                        .padding(0.dp, 12.dp),
                    painter = painterResource(id = image),
                    contentDescription = null,
                    tint = Color.White
                )
                Text(
                    text = stringResource(id = label),
                    color = Color.White
                )
            }
        }
    }

}