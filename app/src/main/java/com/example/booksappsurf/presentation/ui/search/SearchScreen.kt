package com.example.booksappsurf.presentation.ui.search

import androidx.compose.runtime.Composable
import com.example.booksappsurf.presentation.ui.common.SearchBar

@Composable
fun SearchScreen() {
    SearchBar(
        onSearch = { query ->
            println("Search query: $query")
        },
        onClear = {
            println("Search cleared")
        }
    )
}