package com.example.booksappsurf.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.booksappsurf.domain.model.Book
import com.example.booksappsurf.domain.usecase.SearchType

class BooksViewModel : ViewModel() {
    private val _favoriteBooks = MutableStateFlow<List<Book>>(emptyList())
    val favoriteBooks: StateFlow<List<Book>> get() = _favoriteBooks
    fun removeFromFavorites(book: Book) {
        _favoriteBooks.value = _favoriteBooks.value.filter { it.id != book.id }
    }

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> get() = _books

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    fun searchBooks(query: String, searchType: SearchType) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val result = listOf(Book("1", "Sample Book", "Sample Author", "Description", "", false))
                _books.value = result
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Ошибка при поиске: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}