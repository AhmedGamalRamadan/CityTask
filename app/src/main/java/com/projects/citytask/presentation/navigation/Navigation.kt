package com.projects.citytask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.projects.citytask.presentation.screen.CityDetailScreen
import com.projects.citytask.presentation.screen.EndScreen
import com.projects.citytask.presentation.screen.HomeScreen
import com.projects.citytask.presentation.screen.LoginScreen
import com.projects.citytask.presentation.screen.OnBoardingScreen
import com.projects.citytask.presentation.screen.SignUpScreen
import com.projects.citytask.presentation.util.Screen

@Composable
fun Navigation() {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screen.OnBoarding.rout) {

        composable(Screen.OnBoarding.rout) {

            OnBoardingScreen(navHostController = navController)
        }

        composable(Screen.SignUp.rout) {

            SignUpScreen(navHostController = navController)
        }

        composable(Screen.Login.rout) {

            LoginScreen(navHostController = navController)
        }

        composable(Screen.Home.rout) {

            HomeScreen(navHostController = navController)
        }

        composable(
            Screen.Details.rout + "/{cityName}/{cityDescription}/{cityReview}/{cityImage}",
            arguments = listOf(
                navArgument("cityName") { type = NavType.StringType },
                navArgument("cityDescription") { type = NavType.StringType },
                navArgument("cityReview") { type = NavType.IntType },
                navArgument("cityImage") { type = NavType.IntType },
            )
        ) { backStackEntry ->

            CityDetailScreen(navHostController = navController, backStackEntry = backStackEntry)
        }

        composable(Screen.End.rout) {

            EndScreen()
        }
    }
}