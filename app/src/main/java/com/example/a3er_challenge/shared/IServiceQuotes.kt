package com.example.a3er_challenge.shared

import com.example.a3er_challenge.Model.Quote

interface IServiceQuotes {
    suspend fun getQuotes(): List<Quote>?
}
