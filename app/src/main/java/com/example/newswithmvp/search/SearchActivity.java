package com.example.newswithmvp.search;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.newswithmvp.Base.BaseActivity;
import com.example.newswithmvp.R;
import com.example.newswithmvp.data.News;

import java.util.List;

public class SearchActivity extends BaseActivity implements TextWatcher,SearchContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void setProgressIndicator(boolean mustShow) {

    }

    @Override
    public void showResult(List<News> newsList) {

    }

    @Override
    public void showNoResultMessage() {

    }

    @Override
    public void setProgressIndicatore(boolean mustShow) {

    }

    @Override
    public void showError(String errorMsge) {

    }

    @Override
    public Context context() {
        return null;
    }
}
