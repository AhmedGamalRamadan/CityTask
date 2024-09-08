package com.projects.citytask.presentation.screen.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.citytask.domain.model.LoginResponse
import com.projects.citytask.domain.model.SignUpResponse
import com.projects.citytask.domain.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel() {


    private val _signUpResult = MutableStateFlow<Result<SignUpResponse>?>(null)
    val signUpResult = _signUpResult.asStateFlow()

    private val _loginResult = MutableStateFlow<Result<LoginResponse>?>(null)
    val loginResult = _loginResult.asStateFlow()

    fun signUp(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = cityRepository.signUp(name, email, password)
                _signUpResult.value = Result.success(response.body()!!)
            } catch (e: Exception) {
                _signUpResult.value = Result.failure(e)
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = cityRepository.login(email, password)
                _loginResult.value = Result.success(response.body()!!)
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            }
        }
    }
}