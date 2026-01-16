package com.example.watchmodeapp.data.model.response

data class TitleDetailsResponse(
    val id: Int,
    val title: String,
    val plot_overview: String?,
    val release_date: String?,
    val poster: String?,
)