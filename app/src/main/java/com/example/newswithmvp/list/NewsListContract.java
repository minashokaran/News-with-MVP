package com.example.newswithmvp.list;

import com.example.newswithmvp.Base.BasePresenter;
import com.example.newswithmvp.Base.BaseView;
import com.example.newswithmvp.data.News;

import java.util.List;

public interface NewsListContract {
    interface View extends BaseView{
        void showNewsList(List<News> news);

    }

    interface Presenter extends BasePresenter<View>{
        void LoadListNews();
    }
}
