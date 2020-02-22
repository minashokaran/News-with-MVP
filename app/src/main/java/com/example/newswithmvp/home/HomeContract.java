package com.example.newswithmvp.home;

import com.example.newswithmvp.Base.BasePresenter;
import com.example.newswithmvp.Base.BaseView;
import com.example.newswithmvp.data.Banner;
import com.example.newswithmvp.data.News;

import java.util.List;

public interface HomeContract {

    interface View extends BaseView{
        void showNews(List<News> news);
        void showBanners(List<Banner> banners);
    }


    interface Presenter extends BasePresenter<View>{
        void getNewList();



        void getBanners();
    }
}
