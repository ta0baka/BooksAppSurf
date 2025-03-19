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
import com.example.booksappsurf.presentation.theme.BooksAppSurfTheme

@Composable
fun BottomNavigationBar(
    onSearchClick: () -> Unit,
    onFavoritesClick: () -> Unit
) {
    Box(
        modifier = Modifier
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
                    modifier = Modifier
                        .size(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_searchx3),
                        contentDescription = "Search"
                    )
                }
                Text(
                    text = "Поиск",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.LightGray
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                IconButton(
                    onClick = onFavoritesClick,
                    modifier = Modifier
                        .size(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_heartx4),
                        contentDescription = "Favorites"
                    )
                }
                Text(
                    text = "Избранные",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.LightGray
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
            onSearchClick = { println("Search clicked") },
            onFavoritesClick = { println("Favorites clicked") }
        )
    }
}