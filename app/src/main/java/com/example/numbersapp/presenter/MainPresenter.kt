package com.example.numbersapp.presenter

import com.example.numbersapp.api.NumbersApiService
import com.example.numbersapp.view.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val mainView: MainView) {

    fun getRandomNumberTrivia() {

        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val result = NumbersApiService.numbersApi.getNumberTrivia()
                withContext(Dispatchers.Main) {
                    mainView.displayNumberTrivia(result)
                }
            }
        }
    }
}