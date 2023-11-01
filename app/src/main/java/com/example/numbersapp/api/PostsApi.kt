package com.example.numbersapp.api

import com.example.numbersapp.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApi {

    // Get selected post
    @GET("{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    // Get hardcoded post
    @GET("1")
    suspend fun getPost(): Post

    // Get all posts
    @GET(".")
    suspend fun getAllPosts(): List<Post>
}