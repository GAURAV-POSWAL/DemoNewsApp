package com.gaurav.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gaurav.newsapp.model.NewsApiResponse
import com.gaurav.newsapp.model.NewsDataRepository
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsRepo: NewsDataRepository) :
    ViewModel() {

    var news: NewsApiResponse? = null

    fun getNewsData(): LiveData<NewsApiResponse> {

        return newsRepo.getNewsData()
    }

    fun setNewsData(news: NewsApiResponse) {
        this.news = news

    }

}

