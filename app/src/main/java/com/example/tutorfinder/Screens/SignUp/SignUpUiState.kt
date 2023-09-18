package com.example.tutorfinder.Screens.SignUp

data class SignUpUiState(
    val isTutor: Boolean = true,
    val email: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val address: String = "",
    val password: String = "",
    val repeatPassword: String = ""
)
