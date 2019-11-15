package com.t3h.buoi10.models;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String desc;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String img;
    @SerializedName("publishedAt")
    private String publish;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getPublish() {
        return publish;
    }
}
