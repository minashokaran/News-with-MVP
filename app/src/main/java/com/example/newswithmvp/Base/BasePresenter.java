package com.example.newswithmvp.Base;

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void dettachView();

}