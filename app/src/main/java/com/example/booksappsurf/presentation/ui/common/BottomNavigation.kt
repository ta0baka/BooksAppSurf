package com.example.booksappsurf.presentation.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booksapp.R
import androidx.compose.ui.unit.sp
import com.example.booksappsurf.presentation.navigation.Screen
import com.example.booksappsurf.presentation.theme.BooksAppSurfTheme

@Composable
fun BottomNavigationBar(
    currentScreen: Screen,
    onSearchClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp)
            )
            .padding(top = 1.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = onSearchClick,
                    modifier = Modifier.size(30.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = if (currentScreen == Screen.SEARCH) {
                                R.drawable.ic_search_blue
                            } else {
                                R.drawable.ic_search_gray
                            }
                        ),
                        contentDescription = "Search"
                    )
                }
                Text(
                    text = "Поиск",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (currentScreen == Screen.SEARCH) Color(0xFF00ACFF) else Color.LightGray
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = onFavoritesClick,
                    modifier = Modifier.size(30.dp)
                ) {
                    Image(
                        painter = painterResource(
                            id = if (currentScreen == Screen.FAVORITES) {
                                R.drawable.ic_heart_blue
                            } else {
                                R.drawable.ic_heart_gray
                            }
                        ),
                        modifier = Modifier.size(48.dp),
                        contentDescription = "Favorites"
                    )
                }
                Text(
                    text = "Избранное",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (currentScreen == Screen.FAVORITES) Color(0xFF00ACFF) else Color.LightGray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BooksAppSurfTheme {
        BottomNavigationBar(
            currentScreen = Screen.SEARCH,
            onSearchClick = { println("Search clicked") },
            onFavoritesClick = { println("Favorites clicked") }
        )
    }
}