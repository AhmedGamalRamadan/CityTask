package com.projects.citytask.presentation.screen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.projects.citytask.R
import com.projects.citytask.model.City
import com.projects.citytask.presentation.components.CityItem

@Composable
fun HomeScreen(navHostController: NavHostController) {

    val context = LocalContext.current


    val list = listOf(
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city1,
            500
        ),
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city2,
            200
        ),
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city3,
            546
        ),
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city1,
            5453
        ),
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city3,
            5235
        ),
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city2,
            2522
        ),
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city2,
            2522
        ),
        City(
            "United States",
            stringResource(id = R.string.long_text_description),
            R.drawable.city1,
            7653
        )
    )
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
        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = stringResource(id = R.string.popular_cities),
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn {

            items(list) { city ->
                CityItem(
                    city = city,
                    navHostController = navHostController
                )
            }
        }
    }
    BackHandler {
        (context as Activity).finish()
    }
}


