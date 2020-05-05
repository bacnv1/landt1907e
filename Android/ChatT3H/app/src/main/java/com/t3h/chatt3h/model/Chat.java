package com.t3h.chatt3h.model;

import com.google.gson.annotations.SerializedName;
import com.t3h.basemodule.models.BaseModels;

public class Chat extends BaseModels {
    @SerializedName("email")
    private String email;
    @SerializedName("content")
    private String content;
    @SerializedName("pubDate")
    private String pubDate;

    public String getEmail() {
        return email;
    }

    public String getContent() {
        return content;
    }

    public String getPubDate() {
        return pubDate;
    }
}
