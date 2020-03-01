package com.example.newswithmvp.data;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface NewsDataSource {

    Flowable<List<News>> getNews();

    Single<List<News>> getVideos();

    Single<List<Banner>> getBanner();

    void bookmark(News news);

    Single<List<News>> getBookmarkedNews();
    Single<List<News>> search(String keyword);

}
