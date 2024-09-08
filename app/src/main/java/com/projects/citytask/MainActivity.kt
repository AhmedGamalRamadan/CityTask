package com.projects.citytask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.projects.citytask.presentation.navigation.Navigation
import com.projects.citytask.presentation.ui.theme.CityTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CityTaskTheme {
                Navigation()
            }
        }
    }
}