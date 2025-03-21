package com.app.myapplication


import com.app.myapplication.data.remote.ApiService
import com.app.myapplication.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class LoginViewModelTest {


    var mockApiService: ApiService = ApiService()

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        loginViewModel = LoginViewModel(mockApiService)
    }

    @Test
    fun `test empty email should show error message`() {
        // Given: empty email and a password
        val emptyEmail = ""
        val password = "validPassword"

        // When: login() is called
        loginViewModel.login(emptyEmail, password)

        // Then: Ensure that the error message is set for empty email
        assertEquals("Email is required", loginViewModel.loginResult.value)
    }
}
