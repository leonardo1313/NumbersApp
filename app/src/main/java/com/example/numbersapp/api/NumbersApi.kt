package com.example.numbersapp.api

import com.example.numbersapp.model.NumberTrivia
import retrofit2.http.GET
import retrofit2.http.Headers

interface NumbersApi {

    @Headers("Accept: application/json")

    @GET("/random/trivia")
    suspend fun getNumberTrivia(): NumberTrivia
}