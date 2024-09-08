package com.projects.citytask.presentation.screen

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.projects.citytask.R
import com.projects.citytask.presentation.components.CustomButton
import com.projects.citytask.presentation.components.CustomTextField
import com.projects.citytask.presentation.components.CustomTextHeader
import com.projects.citytask.presentation.components.CustomTextSmall
import com.projects.citytask.presentation.screen.authentication.AuthViewModel
import com.projects.citytask.presentation.util.Screen
import com.projects.citytask.presentation.util.isValidEmail


@Composable
fun LoginScreen(navHostController: NavHostController) {

    val viewModel: AuthViewModel = hiltViewModel()
    val loginResult by viewModel.loginResult.collectAsState()

    val context = LocalContext.current

    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember { mutableStateOf(false) }

    val icon = if (isPasswordVisible)
        painterResource(id = R.drawable.ic_eye)
    else
        painterResource(id = R.drawable.image_eye_close)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {


        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_union),
                contentDescription = "Logo",
                tint = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(22.dp))

        CustomTextHeader(text = stringResource(id = R.string.login))

        CustomTextSmall(text = stringResource(id = R.string.enter_personal_info_to_login))

        Spacer(modifier = Modifier.height(18.dp))

        CustomTextSmall(text = stringResource(id = R.string.email))
        CustomTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = !isValidEmail(email)
            },
            placeholder = stringResource(id = R.string.email), trailingIcon = {},
            isError = emailError
        )

        if (emailError) {
            Text(text = "Invalid email", color = Color.Red)
        }

        CustomTextSmall(text = stringResource(id = R.string.password))
        CustomTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = password.length <= 5
            },
            placeholder = stringResource(id = R.string.password),
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
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError
        )

        if (passwordError) {
            Text(text = "Password must be more than 5 characters", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))


        CustomButton(text = stringResource(id = R.string.login)) {

            if (!emailError && !passwordError) 
                viewModel.login(email, password)
            else
                Toast.makeText(context,"Enter the Field Correctly",Toast.LENGTH_LONG).show()

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append(stringResource(id = R.string.don_t_have_an_account_yet_sign_up))
                }
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append(stringResource(id = R.string.sign_up))
                }
            },
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navHostController.navigate(Screen.SignUp.rout)
                }
        )

        loginResult?.let {
            if (it.isSuccess) {
                Toast.makeText(
                    context,
                    stringResource(R.string.login_successful),
                    Toast.LENGTH_LONG
                ).show()
                navHostController.navigate(Screen.Home.rout)
            } else {
                Toast.makeText(context, "${it.exceptionOrNull()?.message}", Toast.LENGTH_LONG)
                    .show()
                Text("Login Failed: ${it.exceptionOrNull()?.message}")
            }
        }
    }
    BackHandler {
        (context as Activity).finish()
    }
}