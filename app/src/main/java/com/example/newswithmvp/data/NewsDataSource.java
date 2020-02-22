package com.example.newswithmvp.data;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface NewsDataSource {

    Flowable<List <News>> getNews();

    Single <List <News>> getVideos();

    Single <List <News> > getBanner();
}
