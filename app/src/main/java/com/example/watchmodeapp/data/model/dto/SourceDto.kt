package com.example.watchmodeapp.data.model.dto

data class SourceDto(
    val id: Int,
    val name: String,
    val type: String,
    val logo_100px: String?,
    val regions: List<String>,
)