package com.gaurav.newsapp.network

import com.gaurav.newsapp.data.NewsApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {
    companion object{
        const val  BASE_URL="https://newsapi.org/"
        const val  API_VERSION="v2/"
        const val COUNTRY_CODE="in"
        const val API_KEY="4924976cf70e42f5bbfbb09e6fe47eaa"

    }
//    https://newsapi.org/v2/top-headlines?country=in&apiKey=4924976cf70e42f5bbfbb09e6fe47eaa
    @GET(API_VERSION + "top-headlines?" + "country=in")
    fun getNewsHeadlines(@Query("apiKey") appID:String= API_KEY):
            Call<NewsApiResponse>

}