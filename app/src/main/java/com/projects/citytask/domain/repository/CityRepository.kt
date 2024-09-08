package com.projects.citytask.domain.repository

import com.projects.citytask.domain.model.LoginResponse
import com.projects.citytask.domain.model.SignUpResponse
import retrofit2.Response

interface CityRepository {

    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Response<SignUpResponse>

    suspend fun login(
        email: String,
        password: String
    ): Response<LoginResponse>


}