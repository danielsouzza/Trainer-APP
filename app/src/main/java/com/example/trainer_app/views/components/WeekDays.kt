package com.example.trainer_app.views.components


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.views.components.Date.dateFormatter
import com.example.trainer_app.views.components.Date.dayOfWeekFormatter
import com.example.trainer_app.views.components.Date.today
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.theme.Shapes
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
object Date{
    private val locale = Locale("pt", "BR")
    val dayOfWeekFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("EEEE", locale)
    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd", locale)
    val today: LocalDate = LocalDate.now()
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekDays(){
    val weekDays = weekDates()
    val selectedDays = remember { mutableStateOf(today.format(dateFormatter)) }
    Row(
        modifier = Modifier
            .background(Background)
            .fillMaxWidth()
            .padding(0.dp, 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        weekDays.forEach{day ->
            DayOfWeek(day = day,selectedDays)
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DayOfWeek(
    day: Day,
    selectedDays: MutableState<String>
){


    val isSelected = selectedDays.value == day.date

    var colorContainer1 = if(isSelected) Primary else Color.Transparent
    var colorContainer2 = if(isSelected) Color.White else Color.Transparent
    var colorText =  if(isSelected) Color.White else Color.Black
    Surface (
        shape = RoundedCornerShape(size = 100.dp),
        color = colorContainer1
    ){
        Column(
            modifier = Modifier
                .clickable {
                    if (!isSelected) {
                        selectedDays.value = day.date
                    }
                }
                .padding(0.dp, 10.dp,0.dp,8.dp)
                .width(45.dp)
                .height(75.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
            ){
            Text(
                modifier=Modifier.padding(0.dp,4.dp),
                text = day.dayOfWeekText,
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                color = colorText
            )
            Surface(
                shape = Shapes.extraLarge,
                color = colorContainer2
            ) {
                Text(
                    modifier=Modifier.clip(CircleShape).padding(3.5.dp,2.dp),
                    text = day.date,
                    fontWeight = FontWeight(500)
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun PreviewCalendar(){
    WeekDays()
}


data class Day(val dayOfWeekText: String, val date: String )

@RequiresApi(Build.VERSION_CODES.O)
fun weekDates(): MutableList<Day> {
    val currentWeek = mutableListOf<Day>()

    for (i in 0 until 7) {
        val date = today.plusDays(i.toLong())
        val dayOfWeekText = date.format(dayOfWeekFormatter)
            .substring(0,3)
            .replaceFirstChar { it.uppercase() }
        val dateText = date.format(dateFormatter)
        currentWeek.add(Day(dayOfWeekText = dayOfWeekText, date = dateText))
    }
    return currentWeek
}