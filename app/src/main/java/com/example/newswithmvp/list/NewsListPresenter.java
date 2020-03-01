package com.example.newswithmvp.list;

import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;
import com.example.newswithmvp.data.NewsDataSource;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NewsListPresenter implements NewsListContract.Presenter {
    private NewsListContract.View view;
    private NewsDataSource newsDataSource;
    private Subscription subscription;

    public NewsListPresenter(NewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
    }

    @Override
    public void LoadListNews() {
        view.setProgressIndicatore(true);
        newsDataSource.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).
                doOnNext(new Consumer<List<News>>() {
                    @Override
                    public void accept(List<News> news) throws Exception {
                        view.showNewsList(news);
                    }
                }).doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                NewsListPresenter.this.subscription = subscription;
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                view.setProgressIndicatore(false);
                view.showError(view.context().getString(R.string.error));
            }
        }).subscribe();
    }

    @Override
    public void attachView(NewsListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (subscription != null)
            subscription.cancel();
    }
}
