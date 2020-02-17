package com.gaurav.newsapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gaurav.newsapp.data.NewsApiResponse

@Database(entities = [NewsApiResponse::class], version = 1)
@TypeConverters(DataConverter::class)
 abstract class RepoDatabase  : RoomDatabase() {
  abstract val repoDao: NewsDao?

}