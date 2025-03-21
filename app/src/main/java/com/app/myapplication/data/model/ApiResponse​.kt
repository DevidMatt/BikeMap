package com.app.myapplication.data.model

data class ApiResponse<T>(
    val result: T?,
    val error: Errors?
)