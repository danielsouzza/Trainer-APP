package com.example.trainer_app.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.BackgroundTopBar
import com.example.trainer_app.views.theme.Shapes
import com.example.trainer_app.views.theme.TextColor

@Composable
fun TopBarAction(
    name: MutableState<String>,
    editable: Boolean,
    onBackPressed: () ->Unit
) {
    Row (
        modifier = Modifier
            .background(Background)
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Surface(
            shape = Shapes.small,
            color = BackgroundTopBar
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 25.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "arrowBack",
                    modifier = Modifier
                        .clickable { onBackPressed() }
                        .clip(CircleShape)

                )
                TextField(
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor= Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        disabledContainerColor= Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    value = name.value,
                    onValueChange = { name.value = it },
                    textStyle = TextStyle(
                        fontWeight = FontWeight(600),
                        color = TextColor,
                        fontSize = 20.sp
                    ),
                    singleLine=true,
                    enabled = editable,
                    trailingIcon={
                        if (editable){
                            Icon(
                                imageVector = Icons.Default.Create,
                                contentDescription = "create",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .clickable {

                                    }
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun View(){
    val name = rememberSaveable {
        mutableStateOf("Treino de Peitoral")
    }
    TopBarAction(name = name, editable = true) {

    }
}