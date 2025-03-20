package com.example.booksappsurf.domain.model

data class Book(
    val id: String,
    val title: String,
    val author: String,
    val description: String,
    val imageUrl: String,
    val isFavorite: Boolean
)