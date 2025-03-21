package com.app.myapplication.data.remote

import com.app.myapplication.data.model.ApiResponse
import com.app.myapplication.data.model.Errors

class ApiService {
    fun login(username: String, password: String): ApiResponse<Int?> {
        return when (username) {
            "user" -> {
                ApiResponse(
                    result = 1,
                    error = null
                )
            }

            "wrong" -> {
                ApiResponse(
                    result = null,
                    error = Errors.WRONG_CREDENTIALS
                )
            }

            "internal" -> {
                ApiResponse(
                    result = null,
                    error = Errors.INTERNAL_SERVER_ERROR
                )
            }

            else -> {
                ApiResponse(
                    result = null,
                    error = Errors.UNKNOWN_ERROR
                )
            }
        }
    }
}