package com.example.newswithmvp.Base;

import android.content.Context;

public interface BaseView {

    void setProgressIndicatore(boolean mustShow);

    void showError(String errorMsge);

    Context context();
}
