package com.example.numbersapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    @Json(name = "body")
    val content: String
)
