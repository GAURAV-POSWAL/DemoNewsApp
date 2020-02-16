package com.gaurav.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gaurav.newsapp.data.Article
import com.gaurav.newsapp.data.NewsApiResponse
import com.gaurav.newsapp.data.NewsDataRepository
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsRepo: NewsDataRepository) : ViewModel() {

    private var news: NewsApiResponse? = null
    var articlesList: ArrayList<Article>? = null

    fun getNewsData(): LiveData<NewsApiResponse> {

        return newsRepo.getNewsData()
    }

    fun setNewsData(news: NewsApiResponse) {
        this.news = news
    }

    fun setNewsArticlesList(articlesList: ArrayList<Article>) {
        this.articlesList = articlesList
    }

}

