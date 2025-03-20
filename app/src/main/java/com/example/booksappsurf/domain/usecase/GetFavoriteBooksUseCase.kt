package com.example.booksappsurf.domain.usecase

import com.example.booksappsurf.domain.model.Book
import com.example.booksappsurf.domain.repository.BookRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetFavoriteBooksUseCase @Inject constructor(
    private val repository: BookRepository
) {
    suspend fun get(): List<Book> {
        return repository.getFavoriteBooks().first()
    }
}