package com.example.newswithmvp.bookmark;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newswithmvp.Base.BaseFragment;
import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;
import com.example.newswithmvp.data.NewsRepositoryProvider;
import com.example.newswithmvp.home.NewsAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class BookmatkFragment extends BaseFragment implements BookmarkContract.View {
    private BookmarkPresenter presenter;
    private View emptyView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new BookmarkPresenter(NewsRepositoryProvider.provideNewsDataSource(getContext()));

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

    @Override
    public void setupViews() {
        emptyView = rootView.findViewById(R.id.frame_bookmark_empty);
    }


    @Override
    public Context context() {
        return getContext();
    }

    @Override
    public int getRecLayout() {
        return R.layout.fragment_bookmark;
    }


    @Override
    public void showBookmarkedNewsList(List<News> news) {
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_bookmark);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new NewsAdapter(news));
    }

    @Override
    public void showEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        emptyView.setVisibility(View.GONE);
    }

    @Override
    public void setProgressIndicatore(boolean mustShow) {
        getBaseActivity().setProgressIndicator(mustShow);

    }

    @Override
    public void showError(String errorMsge) {
        Snackbar.make(rootView, errorMsge, Snackbar.LENGTH_SHORT);
    }
}
