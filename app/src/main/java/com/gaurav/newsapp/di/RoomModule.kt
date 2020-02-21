package com.gaurav.newsapp.di

import android.app.Application

import androidx.room.Room
import com.gaurav.newsapp.data.NewsDataRepository
import com.gaurav.newsapp.data.db.NewsDao
import com.gaurav.newsapp.data.db.RepoDatabase
import com.gaurav.newsapp.network.NewsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class RoomModule(mApplication: Application?) {

    private val demoDatabase: RepoDatabase =
        Room.databaseBuilder(mApplication!!, RepoDatabase::class.java, "demo-db")
            .allowMainThreadQueries().build()


    @Singleton
    @Provides
    fun providesNewsDao(): NewsDao? {
        return demoDatabase.repoDao
    }

    @Singleton
    @Provides
    fun productRepository(newService: NewsService?, productDao: NewsDao?): NewsDataRepository {
        return NewsDataRepository(newService!!, productDao!!)
    }

}