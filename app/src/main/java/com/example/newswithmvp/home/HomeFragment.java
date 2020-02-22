package com.example.newswithmvp.home;

import android.content.Context;

import com.example.newswithmvp.data.Banner;
import com.example.newswithmvp.data.News;

import java.util.List;

public class HomeFragment implements HomeContract.View {
    @Override
    public void showNews(List<News> news) {

    }

    @Override
    public void showBanners(List<Banner> banners) {

    }

    @Override
    public void setProgressIndicatore(boolean mustShow) {

    }

    @Override
    public void showError(String errorMsge) {

    }

    @Override
    public Context context() {
        return null;
    }
}
