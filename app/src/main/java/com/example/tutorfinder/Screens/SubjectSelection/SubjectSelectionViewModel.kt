package com.example.tutorfinder.Screens.SubjectSelection

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SubjectSelectionViewModel : ViewModel() {
    var uiState = mutableStateOf(SubjectSelectionUiState())
        private set

    
}