package com.example.newswithmvp.data;

import android.content.Context;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class NewsRepository implements NewsDataSource {
    private CloudDataSource cloudDataSource;
    private LocalDataSource localDataSource;

    public NewsRepository(Context context) {
        localDataSource=AppDatabase.getInstance(context).getLocalDataSource();
        if (se)
    }


    @Override
    public Flowable<List<News>> getNews() {
       /* cloudDataSource.getNews().subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()).
               doOnNext(new Consumer<List<News>>() {
                   @Override
                   public void accept(List<News> news) throws Exception {
                       cloudDataSource.getNews().
                   }
               }); */

    }

    @Override
    public Single<List<News>> getVideos() {
        return cloudDataSource.getVideos();

    }

    @Override
    public Single<List<Banner>> getBanner() {

        return cloudDataSource.getBanner();
    }

    @Override
    public void bookmark(News news) {
        localDataSource.getBookmarkedNews();
    }

    @Override
    public Single<List<News>> getBookmarkedNews() {
        return localDataSource.getBookmarkedNews();
    }

    @Override
    public Single<List<News>> search(String keyword) {
        return null;
    }

    public void ClearCache(){
        localDataSource.
    }


}



