package com.projects.citytask.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    text: String,
    modifier: Modifier = Modifier,
    onCLick: () -> Unit
) {

    Button(
        onClick = { onCLick() },
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Blue
        )
    ) {

        Text(
            text = text,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun CustomTextHeader(
    text: String,
) {
    Text(
        text = text,
        fontSize = 25.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )
}

@Composable
fun CustomTextSmall(
    text: String,
) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = Color.Gray
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError:Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = { Text(text = placeholder) },
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            containerColor = Color.White

        ),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = { trailingIcon() },
        visualTransformation = visualTransformation,
        isError = isError
    )
}
