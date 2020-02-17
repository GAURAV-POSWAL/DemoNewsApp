package com.gaurav.newsapp.data.db;

import androidx.room.TypeConverter;

import com.gaurav.newsapp.data.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DataConverter {

    @TypeConverter
    public String fromArticleList(List<Article> articles) {
        if (articles == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Article>>() {}.getType();
        String json = gson.toJson(articles, type);
        return json;
    }

    @TypeConverter
    public List<Article> toArticleList(String articleString) {
        if (articleString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Article>>() {}.getType();
        List<Article> countryLangList = gson.fromJson(articleString, type);
        return countryLangList;
    }
 }