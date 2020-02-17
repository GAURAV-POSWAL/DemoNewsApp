package com.gaurav.newsapp.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gaurav.newsapp.R
import com.gaurav.newsapp.data.Article
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity(R.layout.activity_news_detail) {
    lateinit var article: Article

    companion object {
        val INTENT_DATA = "INTENT_DATA"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        article = intent.getParcelableExtra(INTENT_DATA) as Article
        Glide.with(this@NewsDetailActivity)
            .applyDefaultRequestOptions(RequestOptions().error(R.mipmap.ic_launcher))
            .load(article.urlToImage).into(ivNewsSource)
        tvTitle.text = article.title
        tvSource.text = article.source?.name
        tvContent.text = article.content
    }
}