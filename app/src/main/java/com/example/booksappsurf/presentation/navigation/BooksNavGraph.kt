package com.example.booksappsurf.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.booksappsurf.domain.usecase.SearchType
import com.example.booksappsurf.presentation.screens.FavoritesScreen
import com.example.booksappsurf.presentation.screens.SearchScreen
import com.example.booksappsurf.presentation.viewmodel.BooksViewModel

@Composable
fun BooksNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "search") {
        composable("search") {
            val booksViewModel: BooksViewModel = hiltViewModel()
            SearchScreen(navController, booksViewModel, SearchType.ALL)
        }
        composable("favorites") {
            val booksViewModel: BooksViewModel = hiltViewModel()
            FavoritesScreen(navController, booksViewModel)
        }
    }
}