package com.example.newswithmvp.search;

import com.example.newswithmvp.Base.BasePresenter;
import com.example.newswithmvp.Base.BaseView;
import com.example.newswithmvp.data.News;

import java.util.List;

public interface SearchContract {
    interface View extends BaseView {
        void showResult(List<News> newsList);

        void showNoResultMessage();
    }

    interface Presenter extends BasePresenter<View> {
        void search(String keyword);
    }
}
