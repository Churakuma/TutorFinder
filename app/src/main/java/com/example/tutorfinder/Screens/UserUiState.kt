package com.example.tutorfinder.Screens

data class UserUiState(
    val currentUserFirstName: String = "",
    val currentUserLastName: String = "",
    val currentUserID: Int = 0,
    val isUserTutor: Boolean = false
)
