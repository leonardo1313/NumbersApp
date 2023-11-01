package com.example.numbersapp.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val baseUrl = "https://jsonplaceholder.typicode.com/posts/"
object PostsApiService {

    val postsApi: PostsApi = getRetrofit().create(PostsApi::class.java)

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}