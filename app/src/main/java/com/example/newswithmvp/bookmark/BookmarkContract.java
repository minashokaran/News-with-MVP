package com.example.newswithmvp.bookmark;

import com.example.newswithmvp.Base.BasePresenter;
import com.example.newswithmvp.Base.BaseView;
import com.example.newswithmvp.data.News;

import java.util.List;

public interface BookmarkContract {
    interface View extends BaseView {
        void showBookmarkedNewsList(List<News> news);

        void showEmptyView();

        void hideEmptyView();


    }

    interface Presenter extends BasePresenter<View> {
        void loadBookmarkedNews();
    }
}
