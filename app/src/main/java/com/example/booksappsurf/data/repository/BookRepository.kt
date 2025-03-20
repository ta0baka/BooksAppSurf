package com.example.booksappsurf.data.repository

import com.example.booksappsurf.domain.model.Book
import com.example.booksappsurf.domain.repository.BookRepository
import com.example.booksappsurf.data.api.GoogleBooksApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BookRepository @Inject constructor(
    private val googleBooksApiService: GoogleBooksApiService
) : BookRepository {

    override suspend fun searchBooks(query: String): List<Book> {
        return withContext(Dispatchers.IO) {
            try {
                val response = googleBooksApiService.searchBooks(query)
                response.items?.map { item ->
                    Book(
                        id = item.id,
                        title = item.volumeInfo.title,
                        author = item.volumeInfo.authors?.joinToString() ?: "Неизвестный автор",
                        description = item.volumeInfo.description ?: "Описание отсутствует",
                        imageUrl = item.volumeInfo.imageLinks?.thumbnail ?: "",
                        isFavorite = false
                    )
                } ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return flowOf(emptyList())
    }

    override suspend fun addFavorite(book: Book) {
    }

    override suspend fun removeFavorite(book: Book) {
    }

    override suspend fun getBookById(bookId: String): Book? {
        return null
    }
}