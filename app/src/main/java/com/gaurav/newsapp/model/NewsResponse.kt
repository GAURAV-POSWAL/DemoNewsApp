package com.gaurav.newsapp.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("temp")
    val author: String,
    @SerializedName("temp")
    val content: String,
    @SerializedName("temp")
    val description: String,
    @SerializedName("temp")
    val publishedAt: String,
    @SerializedName("temp")
    val source: Source,
    @SerializedName("temp")
    val title: String,
    @SerializedName("temp")
    val url: String,
    @SerializedName("temp")
    val urlToImage: String
)

data class NewsApiResponse(
    @SerializedName("temp")
    val articles: List<Article>,
    @SerializedName("temp")
    val status: String,
    @SerializedName("temp")
    val totalResults: Int
)

data class Source(
    @SerializedName("temp")
    val id: Any,
    @SerializedName("temp")
    val name: String
)