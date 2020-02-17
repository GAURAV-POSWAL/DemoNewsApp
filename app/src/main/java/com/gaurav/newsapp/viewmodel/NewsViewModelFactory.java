package com.gaurav.newsapp.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.gaurav.newsapp.data.NewsDataRepository;

public class NewsViewModelFactory implements ViewModelProvider.Factory {

    private NewsDataRepository repository;

    public NewsViewModelFactory(NewsDataRepository repository){

        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NewsViewModel(repository);
    }
}
