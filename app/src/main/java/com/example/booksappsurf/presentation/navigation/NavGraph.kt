package com.example.booksappsurf.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.booksappsurf.presentation.ui.favorites.FavoritesScreen
import com.example.booksappsurf.presentation.ui.search.SearchScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SEARCH.name
    ) {
        composable(Screen.SEARCH.name) {
            SearchScreen(
                onFavoritesClick = { navController.navigate(Screen.FAVORITES.name) }
            )
        }
        composable(Screen.FAVORITES.name) {
            FavoritesScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}