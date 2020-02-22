package com.example.newswithmvp.newscategory;

import androidx.annotation.DrawableRes;

public class NewsCategory {
    private int id;
    private String title;
    @DrawableRes
    private int icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
