package com.t3h.chatt3h.model;

import com.google.gson.annotations.SerializedName;
import com.t3h.basemodule.models.BaseModels;

public class User extends BaseModels {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("name")
    private String name;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
