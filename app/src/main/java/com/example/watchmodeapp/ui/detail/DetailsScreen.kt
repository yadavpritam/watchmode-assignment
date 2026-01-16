package com.example.watchmodeapp.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun DetailsScreen(
    onBack: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()


    when (state) {
        is DetailsUiState.Loading -> {
            DetailsShimmer()
        }

        is DetailsUiState.Success -> {
            DetailsScreenDesign(
                data = ((state as DetailsUiState.Success).data),
                onBack = onBack,
            )
        }

        is DetailsUiState.Error -> {
            Text(
                text = (state as DetailsUiState.Error).message,
                color = Color.Red
            )
        }
    }
}
