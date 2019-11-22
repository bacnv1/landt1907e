package com.t3h.filternews.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class News {

    @ColumnInfo
    @SerializedName("title")
    private String title;

    @ColumnInfo
    @SerializedName("description")
    private String desc;

    @NonNull
    @PrimaryKey
    @SerializedName("url")
    private String url;

    @ColumnInfo
    @SerializedName("urlToImage")
    private String img;

    @ColumnInfo
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }
}
