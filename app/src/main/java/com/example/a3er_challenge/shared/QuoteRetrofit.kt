package com.example.a3er_challenge.shared


import com.example.a3er_challenge.Model.Quote
import com.example.a3er_challenge.Model.QuoteApi
import javax.inject.Inject

class QuoteRetrofit @Inject constructor(
    private val quoteApi: QuoteApi
) : IServiceQuotes {

    override suspend fun getQuotes(): List<Quote>? {
        return try {
            quoteApi.getQuotes()
        } catch (e: Exception) {
            null
        }
    }
}
