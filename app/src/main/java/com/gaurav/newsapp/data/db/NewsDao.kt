package com.gaurav.newsapp.data.db

import androidx.room.*
import com.gaurav.newsapp.data.Article
import com.gaurav.newsapp.data.NewsApiResponse

@Dao
interface NewsDao {
    @Query("SELECT * FROM NewsApiResponse")
    fun getAll(): NewsApiResponse
    @Insert
    fun insertAll( articles: NewsApiResponse)


    @Query("DELETE FROM NewsApiResponse")
    fun deleteAll()
}