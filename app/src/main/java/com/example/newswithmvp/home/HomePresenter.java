package com.example.newswithmvp.home;

import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;
import com.example.newswithmvp.data.NewsDataSource;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private NewsDataSource newsDataSource;
    private Subscription subscription;
    private CompositeDisposable compositeDisposable;


    public HomePresenter(NewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
    }

    @Override
    public void getNewList() {
        view.setProgressIndicatore(true);
        newsDataSource.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<List<News>>() {
            @Override
            public void accept(List<News> news) {

                view.showNews(news);
                view.setProgressIndicatore(false);
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                view.setProgressIndicatore(true);
                view.showError(view.context().getString(R.string.Error));
            }
        }).doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                HomePresenter.this.subscription = subscription;
            }
        }).subscribe();

    }


    @Override
    public void getBanners() {

    }

    @Override
    public void attachView(HomeContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {
        this.view = null;
        if (compositeDisposable != null && compositeDisposable.size() > 0) {
            compositeDisposable.clear();
        }
        if (subscription != null) {
            subscription.cancel();
        }
    }
}
