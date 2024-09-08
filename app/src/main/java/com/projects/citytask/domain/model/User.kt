package com.projects.citytask.domain.model

data class User(
    val name: String,
    val email: String,
    val password: String

)

data class SignUpResponse(
    val success: Boolean,
    val message: String
)

data class LoginResponse(
    val success: Boolean,
    val token: String
)