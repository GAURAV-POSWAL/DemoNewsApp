package com.gaurav.newsapp.di

import com.gaurav.newsapp.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class,RoomModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)



}