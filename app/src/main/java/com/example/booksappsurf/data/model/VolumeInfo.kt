package com.example.booksappsurf.data.model

data class VolumeInfo(
    val title: String,
    val authors: List<String>?,
    val description: String?,
    val imageLinks: ImageLinks?,
    val publishedDate: String?
)
