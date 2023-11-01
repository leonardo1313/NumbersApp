package com.example.numbersapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.numbersapp.R
import com.example.numbersapp.model.Post
import com.example.numbersapp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var etEnterPostId: EditText
    private lateinit var tvUserId: TextView
    private lateinit var tvPostId: TextView
    private lateinit var tvTitle: TextView
    private lateinit var tvContent: TextView

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEnterPostId = findViewById(R.id.etPostId)
        tvUserId = findViewById(R.id.tvUserId)
        tvPostId = findViewById(R.id.tvPostId)
        tvTitle = findViewById(R.id.tvTitle)
        tvContent = findViewById(R.id.tvContent)

        mainPresenter = MainPresenter(this)

        // Reactive programming (displayed data is changed as the number ids in et change)
        etEnterPostId.addTextChangedListener {
            if (!it.isNullOrEmpty() && it.toString().toInt() != 0 && it.toString().toInt() <= 100) {
                mainPresenter.getPost(it.toString().toInt())
            }
        }
    }

    override fun displayPost(result: Post) {
        tvUserId.text = "User ID: ${result.userId.toString()}"
        tvPostId.text = "Post ID: ${result.id.toString()}"
        tvTitle.text = "Title: ${result.title}"
        tvContent.text = "Content: ${result.content}"
    }

    fun getPostById(view: View) {
        val postId = etEnterPostId.text.trim().toString().toInt()
        mainPresenter.getPost(postId)

        // Print all posts
        //mainPresenter.getAllPosts()
    }
}