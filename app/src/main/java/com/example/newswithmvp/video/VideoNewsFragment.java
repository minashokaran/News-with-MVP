package com.example.newswithmvp.video;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newswithmvp.Base.BaseFragment;
import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;
import com.example.newswithmvp.data.NewsRepository;
import com.example.newswithmvp.home.NewsAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class VideoNewsFragment extends BaseFragment implements VideoNewsContract.View {
    private VideoNewsContract.Presenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new VideoNewsPresenter(new NewsRepository(getContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }

    ;

    @Override
    public void showVideoNewsList(List<News> newsList) {
        RecyclerView recyclerView = rootView.findViewById(R.layout.);
        recyclerView.setLayoutManager(new LinearLayoutManager(context(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new NewsAdapter(newsList));

    }

    @Override
    public void setProgressIndicatore(boolean mustShow) {
        getBaseActivity().setProgressIndicator(mustShow);
    }

    @Override
    public void showError(String errorMsge) {
        Snackbar.make(rootView, errorMsge, Snackbar.LENGTH_SHORT);
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public int getRecLayout() {
        return R.layout.;
    }

    @Override
    public void setupViews() {

    }


}
