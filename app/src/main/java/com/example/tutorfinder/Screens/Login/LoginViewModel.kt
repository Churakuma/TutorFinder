package com.example.tutorfinder.Screens.Login

import androidx.compose.runtime.mutableStateOf
import com.example.tutorfinder.Model.Service.AccountService
import com.example.tutorfinder.Common.Snackbar.SnackbarManager
import com.example.tutorfinder.Common.StringVal.isValidEmail
import com.example.tutorfinder.Model.Service.Impl.AccountServiceImpl
import com.example.tutorfinder.Screens.TutorFinderViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.tutorfinder.R.string as AppText

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService
) : TutorFinderViewModel(){
    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(valueChange: String) {
        uiState.value = uiState.value.copy(email = valueChange)
    }

    fun onPasswordChange(valueChange: String) {
        uiState.value = uiState.value.copy(password = valueChange)
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        if (password.isBlank()) {
            SnackbarManager.showMessage(AppText.empty_password_error)
            return
        }

        launchCatching {
            accountService.authenticate(email, password)
            // TODO: openAndPopUp( <!-- add locations here -->)
        }
    }

    fun onForgotPasswordClick() {
        // TODO: Add composable button for forgotten password

        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        launchCatching {
            accountService.sendRecoveryEmail(email)
            SnackbarManager.showMessage(AppText.recovery_email_sent)
        }
    }
}