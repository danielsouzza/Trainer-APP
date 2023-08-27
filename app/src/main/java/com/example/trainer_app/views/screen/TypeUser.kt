package com.example.trainer_app.views.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trainer_app.R
import com.example.trainer_app.views.theme.Background
import com.example.trainer_app.views.theme.Orange
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.components.AppCard
import com.example.trainer_app.views.components.InfoRegisterScreen
import com.example.trainer_app.views.view_model.RegisterViewModel

@Composable
fun TypeUser(
    viewModel: RegisterViewModel,
    onNavigate: (String) -> Unit
){
    viewModel.changeInfoScreen(InfoRegisterScreen.TypeUser)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color= Background
    ) {
        Row (
            modifier= Modifier
                .fillMaxSize()
                .padding(start=30.dp, end=30.dp,top=100.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            AppCard(image = R.drawable.athlete, label = R.string.athlete, color = Orange) {
                onNavigate("student")
            }
            Spacer(modifier = Modifier.width(30.dp))
            AppCard(image = R.drawable.personal_trainer, label = R.string.trainer, color = Primary) {
                onNavigate("personal")
            }
        }
    }
}

