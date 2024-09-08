package com.projects.citytask.data.remote

import com.projects.citytask.domain.model.LoginResponse
import com.projects.citytask.domain.model.SignUpResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface CityAPIServices {

    @FormUrlEncoded
    @POST("sign_up")
    suspend fun signUp(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<SignUpResponse>

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>

}
