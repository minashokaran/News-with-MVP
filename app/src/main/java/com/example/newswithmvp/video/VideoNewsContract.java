package com.example.newswithmvp.video;

import com.example.newswithmvp.Base.BasePresenter;
import com.example.newswithmvp.Base.BaseView;
import com.example.newswithmvp.data.News;

import java.util.List;

public interface VideoNewsContract {
    interface View extends BaseView {
        void showVideoNewsList(List<News> newsList);
    }

    interface Presenter extends BasePresenter<View> {
        void loadVideoNewsList();
    }
}
