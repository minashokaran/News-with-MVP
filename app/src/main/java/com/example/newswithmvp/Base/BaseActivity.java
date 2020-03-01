package com.example.newswithmvp.Base;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


   /* @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleMa);
    }*/

    public abstract void setProgressIndicator(boolean mustShow);
}
