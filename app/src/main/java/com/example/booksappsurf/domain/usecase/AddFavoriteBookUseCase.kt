package com.example.booksappsurf.domain.usecase

import com.example.booksappsurf.domain.model.Book
import com.example.booksappsurf.domain.repository.BookRepository
import javax.inject.Inject

class AddFavoriteBookUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend fun invoke(book: Book) {
        bookRepository.addFavorite(book)
    }
}