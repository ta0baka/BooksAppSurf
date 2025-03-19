package com.example.booksappsurf.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.booksappsurf.presentation.navigation.AppNavigation
import com.example.booksappsurf.presentation.theme.BooksAppSurfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksAppSurfTheme {
                AppNavigation()
            }
        }
    }
}