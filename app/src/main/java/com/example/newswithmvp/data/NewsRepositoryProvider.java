package com.example.newswithmvp.data;

import android.content.Context;

public class NewsRepositoryProvider {
    public static NewsRepository provideNewsDataSource(Context context){
      return new NewsRepository(context);
    }
}
