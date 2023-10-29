package com.example.numbersapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val baseUrl = "http://numbersapi.com"
object NumbersApiService {

    val numbersApi: NumbersApi = getRetrofit().create(NumbersApi::class.java)

    private val apiClient = OkHttpClient().newBuilder().build()

    private fun getRetrofit() = Retrofit.Builder().client(apiClient)
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

}