package com.gaurav.newsapp.base

import android.app.Application
import androidx.room.Room
import com.gaurav.newsapp.data.db.RepoDatabase
import com.gaurav.newsapp.di.AppComponent
import com.gaurav.newsapp.di.DaggerAppComponent
import com.gaurav.newsapp.di.NetworkModule
import com.gaurav.newsapp.di.RoomModule


class MyApplication : Application() {
        lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().networkModule(NetworkModule())
            .roomModule(RoomModule(this)).build();
    }
}