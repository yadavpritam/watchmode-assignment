package com.example.watchmodeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.watchmodeapp.navigation.Screen
import com.example.watchmodeapp.ui.detail.DetailsScreen
import com.example.watchmodeapp.ui.home.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onItemClick = { id ->
                    navController.navigate(Screen.Details.passId(id))
                }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            DetailsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}