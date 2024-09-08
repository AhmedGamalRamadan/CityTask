package com.projects.citytask.data.repository

import com.projects.citytask.data.remote.CityAPIServices
import com.projects.citytask.domain.repository.CityRepository

class CityRepositoryImpl(
    private val cityAPIServices: CityAPIServices
) : CityRepository {

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ) = cityAPIServices.signUp(name, email, password)


    override suspend fun login(email: String, password: String) =
        cityAPIServices.login(email, password)


}