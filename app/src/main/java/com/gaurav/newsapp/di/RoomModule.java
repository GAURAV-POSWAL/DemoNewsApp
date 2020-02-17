package com.gaurav.newsapp.di;

import android.app.Application;

import androidx.room.Room;

import com.gaurav.newsapp.data.NewsDataRepository;
import com.gaurav.newsapp.data.db.NewsDao;
import com.gaurav.newsapp.data.db.RepoDatabase;
import com.gaurav.newsapp.network.NewsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
public class RoomModule {

    private RepoDatabase demoDatabase;

    public RoomModule(Application mApplication) {

        demoDatabase = Room.databaseBuilder(mApplication, RepoDatabase.class, "demo-db")
        .allowMainThreadQueries().build();
    }

    @Singleton
    @Provides
    RepoDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Singleton
    @Provides
    NewsDao providesNewsDao(RepoDatabase demoDatabase) {
        return demoDatabase.getRepoDao();
    }

    @Singleton
    @Provides
    NewsDataRepository productRepository(NewsService newService ,NewsDao productDao) {
        return new NewsDataRepository(newService,productDao);
    }

}
