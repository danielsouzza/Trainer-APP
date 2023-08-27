package com.example.trainer_app.views.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.R
import com.example.trainer_app.views.components.WeekDays
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.view_model.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExercisesScreen(
    viewModel: MainViewModel
) {
    val user by viewModel.user.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(10.dp, 0.dp)
    ){
        Text(
            text = "Olá ${user?.username?: "Atleta"},",
            fontSize = 18.sp
        )
        Text(
            text = "Bora colocar o Shape",
            fontWeight = FontWeight(600),
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))
        WeekDays()
    }
}
