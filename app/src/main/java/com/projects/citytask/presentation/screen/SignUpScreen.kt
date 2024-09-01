package com.projects.citytask.presentation.screen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.projects.citytask.R
import com.projects.citytask.presentation.components.CustomButton
import com.projects.citytask.presentation.components.CustomTextField
import com.projects.citytask.presentation.components.CustomTextHeader
import com.projects.citytask.presentation.components.CustomTextSmall
import com.projects.citytask.presentation.util.Screen


@Composable
fun SignUpScreen(navHostController: NavHostController) {

    val context = LocalContext.current

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var city by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    var isPasswordVisible by remember { mutableStateOf(false) }

    val icon = if (isPasswordVisible)
        painterResource(id = R.drawable.ic_eye)
    else
        painterResource(id = R.drawable.image_eye_close)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(35.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_union),
                    contentDescription = "Union Icon",
                    tint = Color.Blue,
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            CustomTextHeader(text = stringResource(id = R.string.sign_up))

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextSmall(text = stringResource(id = R.string.phone_number))

            CustomTextField(
                value = phoneNumber, onValueChange = { phoneNumber = it },
                placeholder = stringResource(id = R.string.phone_number),trailingIcon = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomTextSmall(text = stringResource(id = R.string.email))

            CustomTextField(
                value = email, onValueChange = { email = it },
                placeholder = stringResource(id = R.string.email),trailingIcon = {}
            )
            Spacer(modifier = Modifier.height(8.dp))

            CustomTextSmall(text = stringResource(id = R.string.password))

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                placeholder =stringResource(id = R.string.password),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            painter = icon,
                            contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(20.dp)

                        )
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(8.dp))

            CustomTextSmall(text = stringResource(id = R.string.city))

            CustomTextField(
                value = city, onValueChange = { city = it },
                placeholder = stringResource(id = R.string.city), trailingIcon = {}
            )
            Spacer(modifier = Modifier.height(8.dp))

            CustomButton(text = stringResource(id = R.string.sign_up)) {

                navHostController.navigate(Screen.Home.rout)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(stringResource(id = R.string.already_have_an_account))
                    }
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append(stringResource(id = R.string.login))
                    }
                },
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navHostController.navigate(Screen.Login.rout)
                    }
            )

        }
    }

    BackHandler {
        (context as Activity).finish()
    }
}