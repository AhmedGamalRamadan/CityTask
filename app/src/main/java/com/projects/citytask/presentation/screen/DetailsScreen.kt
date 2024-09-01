package com.projects.citytask.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.projects.citytask.presentation.util.Screen


@Composable
fun CityDetailScreen(
    navHostController: NavHostController,
    backStackEntry: NavBackStackEntry
) {

    val cityName = backStackEntry.arguments?.getString("cityName")
    val cityDescription = backStackEntry.arguments?.getString("cityDescription")
    val cityReview = backStackEntry.arguments?.getInt("cityReview")
    val cityImage = backStackEntry.arguments?.getInt("cityImage")

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
            .verticalScroll(scrollState),
    ) {


        Box(
            modifier = Modifier
                .size(55.dp)
                .background(Color.Blue)
                .clip(RoundedCornerShape(22.dp)),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { navHostController.navigateUp() },
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        cityImage?.let {
            Image(
                painter = painterResource(it),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            cityName?.let {
                Text(
                    text = it,
                    fontSize = 24.sp,
                )
            }

            cityReview?.let {
                Text(
                    text = it.toString(),
                    fontSize = 13.sp,
                    color = Color.Blue
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))

        cityDescription?.let {
            Text(
                text = it,
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    navHostController.navigate(Screen.End.rout)
                }
            )
        }

    }
}