package com.example.watchmodeapp.data.model.dto

data class TitleDto(
    val id: Int,
    val title: String,
    val year: Int?,
    val type: String,
    val poster: String?,
    val plot_overview: String?,
)