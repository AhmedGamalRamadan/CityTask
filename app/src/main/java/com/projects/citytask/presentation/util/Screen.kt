package com.projects.citytask.presentation.util


sealed class Screen(val rout: String) {
    object OnBoarding : Screen("onBoardingScreen")
    object SignUp : Screen("signUpScreen")
    object Login : Screen("loginScreen")
    object Details : Screen("detailsScreen")
    object Home : Screen("cityHomeScreen")
    object End : Screen("endScreen")

}