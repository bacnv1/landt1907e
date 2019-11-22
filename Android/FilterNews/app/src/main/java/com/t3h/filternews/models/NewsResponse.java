package com.t3h.filternews.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsResponse {
    @SerializedName("articles")
    private ArrayList<News> articles;

    public ArrayList<News> getArticles() {
        return articles;
    }
}
