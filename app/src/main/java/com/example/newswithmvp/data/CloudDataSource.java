package com.example.newswithmvp.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public abstract class CloudDataSource implements NewsDataSource {
    protected Retrofit retrofit;

    public CloudDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/").
                        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
