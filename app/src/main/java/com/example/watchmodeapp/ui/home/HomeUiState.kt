package com.example.watchmodeapp.ui.home

import com.example.watchmodeapp.data.model.dto.TitleDto

sealed class HomeUiState {

    object Loading : HomeUiState()

    data class Success(
        val movies: List<TitleDto>,
        val tvShows: List<TitleDto>,
    ) : HomeUiState()

    data class Error(
        val message: String,
    ) : HomeUiState()
}