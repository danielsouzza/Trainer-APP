package com.example.trainer_app.views.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainer_app.views.theme.Primary
import com.example.trainer_app.views.theme.Shapes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    valueState: String,
    stringHint: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    onValueChange: (String) -> Unit,
){
    OutlinedTextField(
        value = valueState,
        onValueChange = onValueChange,
        readOnly=readOnly,
        label = {
            Text(
                text = stringHint,
                fontSize = 14.sp
            )
        },
        shape = Shapes.large,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLeadingIconColor = Primary,
            unfocusedBorderColor = Color.Black,
            containerColor = Color.Transparent,
            focusedLabelColor= Primary,
            unfocusedLabelColor= Color.Black,
            cursorColor = Primary
        ),
        modifier = modifier.fillMaxWidth()
            .padding(30.dp,0.dp)
            .height(60.dp),
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = stringHint,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}
