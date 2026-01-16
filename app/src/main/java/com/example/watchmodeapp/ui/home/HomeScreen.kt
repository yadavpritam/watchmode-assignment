package com.example.watchmodeapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    onItemClick: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Movies", "TV Shows")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F1F1F))
    ) {

        // Top App Bar
        TopBar()

        //  Segmented Tabs
        HomeTabs(
            tabs = tabs,
            selectedTab = selectedTab,
            onTabChange = { selectedTab = it }
        )

        when (uiState) {

            is HomeUiState.Loading -> {
                ShimmerList()
            }

            is HomeUiState.Success -> {
                val data = uiState as HomeUiState.Success
                val list =
                    if (selectedTab == 0) data.movies else data.tvShows

                MovieTextList(
                    list = list,
                    onItemClick = onItemClick
                )
            }

            is HomeUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = (uiState as HomeUiState.Error).message,
                        color = Color.Red
                    )
                }
            }
        }
    }
}
