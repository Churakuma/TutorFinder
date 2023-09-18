package com.example.tutorfinder.Common.Snackbar

import android.content.res.Resources
import androidx.annotation.StringRes
import com.example.tutorfinder.R.string as AppText

sealed class SnackbarMessage {
    class StringSnackBar(val message: String) : SnackbarMessage()
    class ResourceSnackbar(@StringRes val message: Int) : SnackbarMessage()

    companion object {
        fun SnackbarMessage.toMessage(resources: Resources): String {
            return when (this) {
                is StringSnackBar -> this.message
                is ResourceSnackbar -> resources.getString(this.message)
            }
        }

        fun Throwable.toSnackbarMessage(): SnackbarMessage {
            val message = this.message.orEmpty()
            return if (message.isNotBlank()) StringSnackBar(message)
            else ResourceSnackbar(AppText.generic_error)
        }
    }
}