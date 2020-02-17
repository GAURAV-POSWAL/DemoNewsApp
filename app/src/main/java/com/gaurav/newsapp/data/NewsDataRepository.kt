package com.gaurav.newsapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gaurav.newsapp.data.db.NewsDao
import com.gaurav.newsapp.network.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDataRepository @Inject constructor(private val newsService: NewsService,
                                             private val repoDao: NewsDao
) {

    fun getNewsData(): LiveData<NewsApiResponse> {
        val newsData: MutableLiveData<NewsApiResponse> = MutableLiveData()
        newsService.getNewsHeadlines().enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(
                call: Call<NewsApiResponse>,
                response: Response<NewsApiResponse?>
            ) {
                if (response.isSuccessful) {
                    //clear db
                    // update db

                    repoDao.deleteAll()
                    response.body()?.let { repoDao.insertAll(it) }
//                    newsData.value = repoDao.getAll()
                }
                newsData.value = repoDao.getAll()

            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable?) {
                newsData.value = repoDao.getAll()
            }
        })
        return newsData

    }
}