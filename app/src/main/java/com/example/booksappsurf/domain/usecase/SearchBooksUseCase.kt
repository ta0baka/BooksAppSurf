package com.example.booksappsurf.domain.usecase

import com.example.booksappsurf.data.repository.BookRepository
import com.example.booksappsurf.domain.model.Book
import javax.inject.Inject

class SearchBooksUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(query: String): List<Book> {
        val books = bookRepository.searchBooks(query)
        return books
    }
}