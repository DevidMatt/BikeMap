package com.app.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.app.myapplication.data.model.Errors
import com.app.myapplication.data.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _loginResult = MutableStateFlow("")
    val loginResult: StateFlow<String> get() = _loginResult


    fun login(username: String, password: String) {
        if (username.isEmpty()) {
            _loginResult.value = "Email is required"
            return
        }

        if (password.isEmpty()) {
            _loginResult.value = "Password is required"
            return
        }

        val response = apiService.login(username, password)
        if (response.error != null) {
            when (response.error) {
                Errors.WRONG_CREDENTIALS -> _loginResult.value = "Wrong credentials"
                Errors.INTERNAL_SERVER_ERROR -> _loginResult.value = "Internal server error"
                Errors.UNKNOWN_ERROR -> _loginResult.value = "Unknown error"
            }
        } else {
            _loginResult.value = "Login successful"
        }
    }
}
