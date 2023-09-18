package com.example.tutorfinder.Model.Service

import kotlinx.coroutines.flow.Flow
import com.example.tutorfinder.Model.User

interface AccountService {
    val currentUserId: String
    val hasUser: Boolean

    val currentUser: Flow<User>

    suspend fun authenticate(email: String, password: String)
    suspend fun sendRecoveryEmail(email: String)
    suspend fun deleteAccount()
    suspend fun signOut()
}