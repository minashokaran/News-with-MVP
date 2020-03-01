package com.example.newswithmvp.bookmark;

import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;
import com.example.newswithmvp.data.NewsDataSource;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BookmarkPresenter implements BookmarkContract.Presenter {
    private BookmarkContract.View view;
    private NewsDataSource newsDataSource;
    private Disposable disposable;

    public BookmarkPresenter(NewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
    }

    @Override
    public void attachView(BookmarkContract.View view) {
        this.view = view;
        loadBookmarkedNews();
    }

    @Override
    public void detachView() {
        this.view = null;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    public void loadBookmarkedNews() {
        view.setProgressIndicatore(true);
        newsDataSource.getBookmarkedNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<News>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onSuccess(List<News> news) {
                        view.setProgressIndicatore(false);
                        if (news.isEmpty()) {
                            view.showEmptyView();
                        } else {
                            view.showBookmarkedNewsList(news);
                            view.hideEmptyView();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.setProgressIndicatore(false);
                        view.showError(view.context().getString(R.string.error));
                    }
                });

    }}