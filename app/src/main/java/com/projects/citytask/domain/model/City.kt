package com.projects.citytask.domain.model

import androidx.annotation.DrawableRes

data class City(
    val cityName: String,
    val cityDescription: String,
    @DrawableRes val cityImage: Int,
    val cityReview: Int,
)
