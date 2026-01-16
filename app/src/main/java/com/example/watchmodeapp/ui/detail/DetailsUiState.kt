package com.example.watchmodeapp.ui.detail

import com.example.watchmodeapp.data.model.response.TitleDetailsResponse

sealed class DetailsUiState {
    object Loading : DetailsUiState()
    data class Success(val data: TitleDetailsResponse) : DetailsUiState()
    data class Error(val message: String) : DetailsUiState()
}