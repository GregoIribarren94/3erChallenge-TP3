package com.example.a3er_challenge.shared

import com.example.a3er_challenge.Model.Quote
import javax.inject.Inject

class GetServiceQuotes @Inject constructor(
    private val service: IServiceQuotes
) {
    suspend fun invoke(): List<Quote>? = service.getQuotes()
}
