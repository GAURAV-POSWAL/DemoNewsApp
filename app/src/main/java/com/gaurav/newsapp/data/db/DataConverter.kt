package com.gaurav.newsapp.data.db

import androidx.room.TypeConverter
import com.gaurav.newsapp.data.Article
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {
    @TypeConverter
    fun fromArticleList(articles: List<Article?>?): String? {
        if (articles == null) {
            return null
        }
        val gson = Gson()
        val type =
            object : TypeToken<List<Article?>?>() {}.type
        return gson.toJson(articles, type)
    }

    @TypeConverter
    fun toArticleList(articleString: String?): List<Article>? {
        if (articleString == null) {
            return null
        }
        val gson = Gson()
        val type =
            object : TypeToken<List<Article?>?>() {}.type
        return gson.fromJson<List<Article>>(articleString, type)
    }
}