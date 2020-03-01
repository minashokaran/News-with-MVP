package com.example.newswithmvp.video;


import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;
import com.example.newswithmvp.data.NewsDataSource;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoNewsPresenter implements VideoNewsContract.Presenter {
    private VideoNewsContract.View view;
    private Disposable disposable;
    private NewsDataSource newsDataSource;
    private boolean isVideoRendered;

    public VideoNewsPresenter(NewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
    }

    @Override
    public void loadVideoNewsList() {
        view.setProgressIndicatore(true);
        newsDataSource.getVideos().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<News>>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onSuccess(List<News> news) {
                view.showVideoNewsList(news);
                view.setProgressIndicatore(false);
                isVideoRendered = true;
            }

            @Override
            public void onError(Throwable e) {
                view.setProgressIndicatore(false);
                view.showError(view.context().getString(R.string.error));
            }
        });
    }

    @Override
    public void attachView(VideoNewsContract.View view) {
        this.view = view;
        if (!isVideoRendered) {
            loadVideoNewsList();
        }

    }

    @Override
    public void detachView() {
        this.view = null;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }

    }
}
