package com.example.numbersapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.numbersapp.R
import com.example.numbersapp.model.NumberTrivia
import com.example.numbersapp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var tvContent: TextView
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvContent = findViewById(R.id.tvContent)
        mainPresenter = MainPresenter(this)
    }

    override fun displayNumberTrivia(result: NumberTrivia) {
        tvContent.text = result.triviaText
    }

    fun getNewNumberTrivia(view: View) {
        mainPresenter.getRandomNumberTrivia()
    }
}