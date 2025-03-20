package com.example.booksappsurf.data.mapper

import com.example.booksappsurf.data.database.BookEntity
import com.example.booksappsurf.domain.model.Book

class BookMapper {

    fun toBook(bookEntity: BookEntity): Book {
        return Book(
            id = bookEntity.id,
            title = bookEntity.title,
            author = bookEntity.author,
            description = bookEntity.description,
            imageUrl = bookEntity.imageUrl,
            isFavorite = bookEntity.isFavorite
        )
    }

    fun toBookEntity(book: Book): BookEntity {
        return BookEntity(
            id = book.id,
            title = book.title,
            author = book.author,
            description = book.description,
            imageUrl = book.imageUrl,
            isFavorite = book.isFavorite
        )
    }
}