package com.gaurav.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gaurav.newsapp.data.Article
import com.gaurav.newsapp.data.NewsApiResponse
import com.gaurav.newsapp.data.NewsDataRepository
import javax.inject.Inject

class NewsViewModel constructor(private val newsRepo: NewsDataRepository) : ViewModel() {

    private var news: NewsApiResponse? = null
    var articlesList: List<Article>? = null

    fun getNewsData(): LiveData<NewsApiResponse> {

        return newsRepo.getNewsData()
    }

    fun setNewsData(news: NewsApiResponse) {
        this.news = news
    }

    fun setNewsArticlesList(articlesList: List<Article>) {
        this.articlesList = articlesList
    }

}

