package com.example.newswithmvp.data;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NewsRepository implements NewsDataSource {
    private CloudDataSource cloudDataSource;
    private LocalDataSource localDataSource;

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
    public Single<List<News>> getBanner() {

        return cloudDataSource.getBanner();
    }
}
