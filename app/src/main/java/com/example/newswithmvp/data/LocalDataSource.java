package com.example.newswithmvp.data;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class LocalDataSource implements NewsDataSource {
    @Override
    public Flowable<List<News>> getNews() {
        return null;
    }

    @Override
    public Single<List<News>> getVideos() {
        return null;
    }

    @Override
    public Single<List<Banner>> getBanner() {
        return null;
    }

    @Override
    public void bookmark(News news) {

    }

    @Override
    public Single<List<News>> getBookmarkedNews() {
        return null;
    }
}
