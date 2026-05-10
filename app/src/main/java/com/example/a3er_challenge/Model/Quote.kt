package com.example.a3er_challenge.Model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quote")   val quote: String,
    @SerializedName("author")  val author: String,
    @SerializedName("category") val category: String
)
