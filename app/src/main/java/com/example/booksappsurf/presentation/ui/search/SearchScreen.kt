package com.example.booksappsurf.presentation.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksappsurf.presentation.ui.common.BottomNavigationBar
import com.example.booksappsurf.presentation.ui.common.SearchBar
import com.example.booksappsurf.presentation.theme.BooksAppSurfTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.booksappsurf.presentation.navigation.Screen

@Composable
fun SearchScreen(onFavoritesClick: () -> Unit) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentScreen = Screen.SEARCH,
                onSearchClick = { println("Search clicked") },
                onFavoritesClick = onFavoritesClick
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                SearchBar(
                    onSearch = { query -> println("Search query: $query") },
                    onClear = { println("Search cleared") }
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Введите название книги,\nкоторую ищете",
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    BooksAppSurfTheme {
        SearchScreen(){}
    }
}