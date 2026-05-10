package com.example.a3er_challenge.Model

import retrofit2.http.GET

interface QuoteApi {
    // Returns a list because the endpoint returns a JSON array
    @GET("v1/quotes")
    suspend fun getQuotes(): List<Quote>
}
