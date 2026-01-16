package com.example.watchmodeapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{id}") {
        fun passId(id: Int) = "details/$id"
    }

}