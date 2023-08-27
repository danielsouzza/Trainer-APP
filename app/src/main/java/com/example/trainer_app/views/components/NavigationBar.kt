package com.example.trainer_app.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.theme.Primary_variant
import com.example.trainer_app.views.theme.Shapes

@Composable
fun NavigationBar(
    navHostController: NavHostController,
    screens: List<BottomBarScreen>
){
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(
        modifier= Modifier.padding(10.dp,10.dp),
        shape = Shapes.large,
        color = Color.White
    ){
        Row(
            modifier = Modifier
                .height(70.dp)
                .padding(10.dp, 0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            screens.forEach { screen ->
                addItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navHostController
                )
            }
        }
    }
}

@Composable
fun RowScope.addItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true
    val background = if (selected) Primary_variant else Color.Transparent
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable {
                navController.popBackStack()
                navController.navigate(screen.route)
            }
    ){
        Column (
            modifier = Modifier
                .padding(12.dp, 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                modifier= Modifier
                    .size(30.dp),
                imageVector = screen.icon,
                contentDescription = null,
                tint = if(selected) Primary else Color.Black
            )
        }
    }
}
