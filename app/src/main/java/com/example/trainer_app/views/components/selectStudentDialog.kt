package com.example.trainer_app.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.R
import com.example.trainer_app.data.models.User
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.ButtonColors
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.theme.Shapes
import com.example.trainer_app.views.theme.ShapesCards
import com.example.trainer_app.views.theme.TextColor
import com.example.trainer_app.views.view_model.CreateProgramViewModel

@Composable
fun BoxScope.SelectStudentDialog(
    viewModel: CreateProgramViewModel,
    onClose: () -> Unit
){
    var search by remember {
        mutableStateOf("")
    }

    val students by viewModel.studentsState.collectAsState()

    var studentSelected = remember {
        mutableStateOf(0)
    }

    Surface(
        shape = ShapesCards.large,
        color = Background,
        modifier = Modifier.align(Alignment.BottomCenter)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 20.dp)
        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(vertical = 25.dp, horizontal = 10.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = "Adicionar exercício",
                    fontSize = 20.sp
                )
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { onClose() }
                        .clip(CircleShape)
                )
            }
            Surface(
                shape = Shapes.medium,
                color = Color(0xFFDEE2E3)
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextField(
                        value = search,
                        onValueChange = { search = it},
                        textStyle= TextStyle(
                            fontSize = 16.sp
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        },
                        colors= TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedContainerColor= Color.Transparent,
                            unfocusedContainerColor= Color.Transparent,
                        ),
                        singleLine=true,
                        modifier = Modifier
                    )
                }
            }
            Surface(
                shape = Shapes.medium,
                color = Color.Transparent
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            item {
                                Spacer(modifier = Modifier.height(5.dp))
                            }
                            itemsIndexed(students) { index,item ->
                                StudentItem(item = item, index= index, studentSelected= studentSelected){
                                    studentSelected.value = index
                                }
                            }
                            item {
                                Spacer(modifier = Modifier.height(5.dp))
                            }
                        }
                    }
                    DefaultButton(text = "SALVAR", colors = ButtonColors("blue")) {
                        viewModel.setStudent(students[studentSelected.value])
                        onClose()
                    }
                }
            }
        }
    }
}

@Composable
fun StudentItem(
    item: User,
    index:Int,
    studentSelected: MutableState<Int>,
    selectItem: () -> Unit
){

    var selected = studentSelected.value == index
    Surface (
        shape = Shapes.small,
        color = Color.White,
        modifier = Modifier
            .clickable {
                selected = !selected
                selectItem()
            }
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Image(painter = painterResource(id = R.drawable.pectoral), contentDescription ="" )
            Text(text = item.name)
            RadioButton(
                selected = selected,
                onClick = {
                    selected = !selected
                },
                colors = RadioButtonDefaults.colors(
                    unselectedColor = Primary,
                    selectedColor = TextColor
                )
            )
        }
    }
}