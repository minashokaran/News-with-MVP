package com.example.newswithmvp.data;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class FarsiCloudDataSource extends CloudDataSource {
    private FarsiApiService farsiApiService;

    public FarsiCloudDataSource(){
        super();
        farsiApiService=retrofit.create(FarsiApiService.class);
    }
    @Override
    public Flowable<List<News>> getNews() {
        return farsiApiService.getNews();
    }

    @Override
    public Single<List<News>> getVideos() {
        return farsiApiService.getVideoNews();
    }

    @Override
    public Single<List<Banner>> getBanner() {
        return farsiApiService.getBanners();
    }

    @Override
    public void bookmark(News news) {

    }

    @Override
    public Single<List<News>> getBookmarkedNews() {
        return null;
    }

    @Override
    public Single<List<News>> search(String keyword) {
        return null;
    }
}
