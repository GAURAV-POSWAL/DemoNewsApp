package com.gaurav.newsapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
data class NewsApiResponse(

    @PrimaryKey(autoGenerate = true)
    val uid: Int,

    @SerializedName("articles")

    val articles: List<Article>,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)

@Parcelize
data class Article(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("source")
    val source: Source?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?
): Parcelable

@Parcelize
data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
): Parcelable