package com.gaurav.newsapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gaurav.newsapp.network.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class NewsDataRepository @Inject constructor(private val newsService: NewsService) {

    // hit the apis here

    fun getNewsData(): LiveData<NewsApiResponse> {
        val newsData: MutableLiveData<NewsApiResponse> = MutableLiveData()
        newsService.getNewsHeadlines().enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(
                call: Call<NewsApiResponse>,
                response: Response<NewsApiResponse?>
            ) {
                if (response.isSuccessful) {
                    newsData.value = response.body()
                } else {
                    newsData.value = null
                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable?) {
                newsData.value = null
            }
        })
        return newsData

    }
}