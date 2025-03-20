package com.example.booksappsurf.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.booksapp.R
import com.example.booksappsurf.domain.model.Book
import com.example.booksappsurf.presentation.navigation.Screen
import com.example.booksappsurf.presentation.ui.common.BottomNavigationBar
import com.example.booksappsurf.presentation.viewmodel.BooksViewModel

@Composable
fun FavoritesScreen(
    navController: NavController,
    booksViewModel: BooksViewModel
) {
    val favoriteBooks = booksViewModel.favoriteBooks.collectAsState().value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.size(48.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Back",
                        modifier = Modifier.size(35.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Избранное",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.size(48.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (favoriteBooks.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    items(favoriteBooks) { book ->
                        BookItem(
                            book = book,
                            onFavoriteClick = {
                                booksViewModel.removeFromFavorites(book)
                            }
                        )
                    }
                }
            }
        }

        BottomNavigationBar(
            currentScreen = Screen.FAVORITES,
            onSearchClick = { navController.navigate("search") },
            onFavoritesClick = {},
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BookItem(
    book: Book,
    onFavoriteClick: (Book) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = book.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = book.author,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    val navController = rememberNavController()
    val booksViewModel = hiltViewModel<BooksViewModel>()

    FavoritesScreen(
        navController = navController,
        booksViewModel = booksViewModel
    )
}