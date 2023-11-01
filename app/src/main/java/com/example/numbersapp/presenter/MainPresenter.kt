package com.example.numbersapp.presenter

import com.example.numbersapp.api.PostsApiService
import com.example.numbersapp.view.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val mainView: MainView) {

    fun getPost(id: Int) {

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val result = PostsApiService.postsApi.getPostById(id)
                withContext(Dispatchers.Main) {
                    mainView.displayPost(result)
                }
            }
        }
    }

    fun getAllPosts() {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val listOfPosts = PostsApiService.postsApi.getAllPosts()
                for (post in listOfPosts) {
                    println(post)
                }
            }
        }
    }
}