package com.example.trainer_app.views.screen

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.trainer_app.R
import com.example.trainer_app.data.models.Exercise
import com.example.trainer_app.views.components.DayOfWeek
import com.example.trainer_app.views.components.DefaultButton
import com.example.trainer_app.views.components.SelectStudentDialog
import com.example.trainer_app.views.components.SelectedStudentCard
import com.example.trainer_app.views.components.TopBarAction
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.BackgroundTopBar
import com.example.trainer_app.views.theme.Black90
import com.example.trainer_app.views.theme.ButtonColors
import com.example.trainer_app.views.theme.Orange
import com.example.trainer_app.views.theme.Orange_1
import com.example.trainer_app.views.theme.Secondary
import com.example.trainer_app.views.theme.Secondary_1
import com.example.trainer_app.views.theme.Secondary_2
import com.example.trainer_app.views.theme.Secondary_3
import com.example.trainer_app.views.theme.Secondary_4
import com.example.trainer_app.views.theme.Shapes
import com.example.trainer_app.views.theme.ShapesCards
import com.example.trainer_app.views.theme.TextColor
import com.example.trainer_app.views.view_model.CreateProgramViewModel


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateProgram(
    viewModel: CreateProgramViewModel,
    navigator: NavHostController
) {

    var selectedDays by rememberSaveable {
        mutableStateOf(setOf<DayOfWeek>())
    }
    val title = rememberSaveable {
        mutableStateOf("Novo treino")
    }

    var expandedSelectExercises = remember {
        mutableStateOf(false)
    }
    var expandedSelectStudent = remember {
        mutableStateOf(false)
    }

    val activity = LocalView.current.context as Activity
    var colorBgExpandDialog = if (expandedSelectExercises.value || expandedSelectStudent.value) Black90 else Color.Transparent

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold (
            topBar = {
                TopBarAction(
                    name = title,
                    editable = true
                ){

                }
            },
            bottomBar = {
                Row (
                    modifier = Modifier
                        .background(Background)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Surface(
                        color = BackgroundTopBar,
                    ) {
                        DefaultButton(
                            text = "Salvar",
                            colors = ButtonColors("blue")
                        ) {

                        }
                    }
                }
            }
        ){
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Background),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ContentForm(
                    viewModel=viewModel,
                    selectedDays= selectedDays,
                    expandedSelectStudent = expandedSelectStudent,
                    expandedSelectExercise= expandedSelectExercises,
                    activity = activity
                ){day->
                    selectedDays = if (selectedDays.contains(day)) {
                        selectedDays - day
                    } else {
                        selectedDays + day
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .zIndex(99f)
                .background(color = colorBgExpandDialog)
                .fillMaxSize()
        ){
            AnimatedVisibility(
                visible = expandedSelectExercises.value,
                enter = fadeIn() + slideInVertically { fullHeight -> fullHeight },
                exit = fadeOut() + slideOutVertically { fullHeight -> fullHeight }
            ) {

                SelectExercisesDialog(viewModel){
                    expandedSelectExercises.value = false
                    activity.window.statusBarColor = Background.toArgb()
                }
            }
            AnimatedVisibility(
                visible = expandedSelectStudent.value,
                enter = fadeIn() + slideInVertically { fullHeight -> fullHeight },
                exit = fadeOut() + slideOutVertically { fullHeight -> fullHeight }
            ) {

                SelectStudentDialog(viewModel){
                    expandedSelectStudent.value = false
                    activity.window.statusBarColor = Background.toArgb()
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContentForm(
    viewModel: CreateProgramViewModel,
    selectedDays:Set<DayOfWeek>,
    expandedSelectExercise: MutableState<Boolean>,
    expandedSelectStudent: MutableState<Boolean>,
    activity: Activity,
    onDaySelected: (DayOfWeek) -> Unit,
) {

    Surface(
        shape = ShapesCards.large,
        color = BackgroundTopBar,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    )
    {
        Column (
            modifier= Modifier
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                AddButton(){
                    expandedSelectExercise.value = true
                    activity.window.statusBarColor = Black90.toArgb()
                }
                Spacer(modifier = Modifier.width(10.dp))
                SelectedStudentCard (viewModel){
                    expandedSelectStudent.value = true
                    activity.window.statusBarColor = Black90.toArgb()
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            DayOfWeek(selectedDays, onDaySelected)
            Spacer(modifier = Modifier.height(0.dp))
            ExercisesScroll(viewModel=viewModel)
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ExercisesScroll(
    viewModel: CreateProgramViewModel,
){


    Surface(
        shape = Shapes.small,
        color = Color.Transparent,
        modifier = Modifier.padding(top = 5.dp)
    ) {
        LazyColumn(
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            userScrollEnabled = true,

        ){
            items(
                items= viewModel.exercisesSelected.value,
                key = {item -> item.id  }

            ){ item->
                var isExpanded by remember { mutableStateOf(false) }
                val state = rememberDismissState(
                    initialValue = DismissValue.Default,
                    confirmValueChange = {
                        if((it == DismissValue.DismissedToEnd) && !isExpanded ){
                            viewModel.removeItem(item)
                            true
                        }else{
                            false
                        }
                    },
                    positionalThreshold = {it / 1.5f }
                )
                SwipeToDismiss(
                    state = state,
                    modifier = Modifier
                        .padding(vertical = 1.dp)
                        .animateItemPlacement(),
                    background = {
                        val color = when(state.dismissDirection){
                            DismissDirection.StartToEnd -> Orange_1
                            DismissDirection.EndToStart -> Color.White
                            null -> Color.Transparent
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(shape = Shapes.medium, color = color)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.delete),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .padding(start = 10.dp),
                                tint = Orange
                            )
                        }
                    },
                    dismissContent ={
                        ExercisesItem(item = item, isExpanded= isExpanded){
                            isExpanded = !isExpanded
                        }

                    },
                    directions = setOf(DismissDirection.StartToEnd)
                )
            }
        }
    }
}

@Composable
fun ExercisesItem(
    item: Exercise,
    isExpanded: Boolean,
    onExpanded: ()->Unit
){

    var seriesList by remember { mutableStateOf( mutableListOf<Int>()) }
    val iconRow = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
    Surface (
        shape = Shapes.medium,
        color = Color.White,
        modifier = Modifier
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    modifier= Modifier
                        .clickable {
                            onExpanded()
                        }
                        .padding(start = 5.dp)
                        .size(30.dp),
                    imageVector = iconRow,
                    contentDescription ="",
                    tint = Secondary
                )
                Image(
                    painter = painterResource(id = R.drawable.pectoral),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text(
                        text = item.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = TextColor
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    AnimatedVisibility(visible = !isExpanded) {
                        Surface (
                            shape = Shapes.small,
                            color = Secondary_1
                        ){
                            Text(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                                text = "${seriesList.size} séries",
                                color= Secondary,
                                fontWeight = FontWeight(600)
                            )
                        }
                    }
                }
            }
            AnimatedVisibility(visible = isExpanded) {
                Column (
                    modifier= Modifier
                        .fillMaxSize()
                        .padding(horizontal = 18.dp)
                        .padding(bottom = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    seriesList.forEachIndexed{idx, set->
                        SereItem(set = set, index=idx)
                    }

                    Button(
                        modifier= Modifier
                            .fillMaxWidth()
                            .height(30.dp),
                        onClick = {
                            val updatedList = seriesList.toMutableList()
                            updatedList.add(0)
                            seriesList = updatedList
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Secondary_2,
                        ),
                        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 0.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                        Text(text = "Adicionar série")
                    }
                }
            }
        }
    }
}

@Composable
fun SereItem(set: Int, index: Int){
    var value by remember {
        mutableStateOf(set.toString())
    }
    Surface (
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        color = Secondary_1,
        shape = Shapes.medium
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                text = "${index+1} série",
                color = Secondary,
                fontWeight = FontWeight(500)
            )
            Surface(
                color = Secondary_3,
                shape = Shapes.medium
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = {
                        value = it
                    },
                    textStyle = TextStyle(
                        color = TextColor,
                        textAlign = TextAlign.Center
                    ),
                    singleLine= true
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                text = "Rep",
                color = Secondary,
                fontWeight = FontWeight(500)
            )
        }
    }
}

@Composable
fun DayOfWeek(
    selectedDays:Set<DayOfWeek>,
    onDaySelected: (DayOfWeek) -> Unit
){


    val days = DayOfWeek.values()
    Surface(
        shape = Shapes.medium,
        color = Orange_1
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp, horizontal = 2.dp)
                .height(60.dp)
        ) {
            days.forEach() {day->
                DayItem(
                    day = day,
                    isSelected = selectedDays.contains(day)
                ){
                    onDaySelected(day)
                }
            }
        }
    }
}

@Composable
fun DayItem(
    day: DayOfWeek,
    isSelected:Boolean,
    onDaySelected: () -> Unit
){
    var colorBack = if (isSelected) Color.White else Color.Transparent
    Surface(
        shape = Shapes.extraLarge,
        color = colorBack,
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .clickable {
                    onDaySelected()
                },
        ){
            Text(
                text = day.label,
                textAlign = TextAlign.Center,
                color = Orange
            )
        }
    }
}

@Composable
fun AddButton(
    addItem: ()->Unit
) {
    Button(
        onClick = { addItem() },
        shape = Shapes.medium,
        modifier = Modifier.height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Secondary_4
        ),
        contentPadding = PaddingValues(
            start = 10.dp,
            top = 12.dp,
            end = 10.dp,
            bottom = 12.dp
        )

    ) {
        Icon(

            imageVector = Icons.Default.Add,
            contentDescription = "add"
        )
        Text(
            text = "Adicionar exercício",
            fontSize= 16.sp,
            fontWeight = FontWeight(600)
        )
    }
}