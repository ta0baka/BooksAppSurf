package com.example.booksappsurf.data.api

import com.example.booksappsurf.data.model.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookResponse
}