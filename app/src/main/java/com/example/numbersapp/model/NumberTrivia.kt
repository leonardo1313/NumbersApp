package com.example.numbersapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberTrivia(
    @Json(name = "text")
    val triviaText: String,
    val number: String,
    val found: Boolean,
    val type: String
)