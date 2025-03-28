package com.example.booksappsurf.domain.usecase

import com.example.booksappsurf.domain.model.Book
import com.example.booksappsurf.domain.repository.BookRepository
import javax.inject.Inject

class RemoveFavoriteBookUseCase @Inject constructor(
    private val repository: BookRepository
) {
    suspend fun remove(book: Book) {
        repository.removeFavorite(book)
    }
}