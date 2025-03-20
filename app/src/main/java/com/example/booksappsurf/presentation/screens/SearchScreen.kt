package com.example.booksappsurf.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.booksappsurf.domain.model.Book
import com.example.booksappsurf.domain.usecase.SearchType
import com.example.booksappsurf.presentation.navigation.Screen
import com.example.booksappsurf.presentation.theme.BooksAppSurfTheme
import com.example.booksappsurf.presentation.ui.common.BookItem
import com.example.booksappsurf.presentation.ui.common.BottomNavigationBar
import com.example.booksappsurf.presentation.ui.common.SearchBar
import com.example.booksappsurf.presentation.viewmodel.BooksViewModel

@Composable
fun SearchScreen(
    navController: NavHostController,
    booksViewModel: BooksViewModel = hiltViewModel(),
    searchType: SearchType
) {
    val books by booksViewModel.books.collectAsState()
    val errorMessage by booksViewModel.errorMessage.collectAsState()
    val loading by booksViewModel.loading.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentScreen = Screen.SEARCH,
                onSearchClick = {},
                onFavoritesClick = { navController.navigate(Screen.FAVORITES.route) }
            )
        }
    ) { innerPadding ->
        SearchScreenContent(
            books = books,
            loading = loading,
            errorMessage = errorMessage,
            onSearch = { query -> booksViewModel.searchBooks(query, searchType) },
            onClear = { booksViewModel.searchBooks("", searchType) },
            onFavoriteClick = { navController.navigate(Screen.FAVORITES.route) },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun SearchScreenContent(
    books: List<Book>,
    loading: Boolean,
    errorMessage: String?,
    onSearch: (String) -> Unit,
    onClear: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar(
            onSearch = { query ->
                searchText = query
                onSearch(query)
            },
            onClear = {
                searchText = ""
                onClear()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        when {
            loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))

            errorMessage != null -> {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = { onClear() },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Попробовать еще")
                }
            }

            books.isEmpty() && searchText.isNotEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "По вашему запросу ничего\nне найдено",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            searchText.isNotEmpty() && books.isNotEmpty() -> {
                LazyColumn {
                    items(books, key = { it.id }) { book ->
                        BookItem(
                            title = book.title,
                            author = book.author,
                            isFavorite = book.isFavorite,
                            onFavoriteClick = {}
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    BooksAppSurfTheme {
        val navController = rememberNavController()

        SearchScreen(
            navController = navController,
            searchType = SearchType.TITLE
        )
    }
}