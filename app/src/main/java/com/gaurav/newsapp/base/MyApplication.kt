package com.gaurav.newsapp.base

import android.app.Application
import com.gaurav.newsapp.di.DaggerAppComponent

class MyApplication : Application() {
    val appComponent = DaggerAppComponent.create()

}