package com.example.booksappsurf.domain.repository

import com.example.booksappsurf.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getFavoriteBooks(): Flow<List<Book>>
    suspend fun addFavorite(book: Book)
    suspend fun removeFavorite(book: Book)
    suspend fun searchBooks(query: String): List<Book>
    suspend fun getBookById(bookId: String): Book?
}