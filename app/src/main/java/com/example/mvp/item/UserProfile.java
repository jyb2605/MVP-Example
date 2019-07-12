package com.example.mvp.item;

import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @SerializedName("login")
    private String mName;

    @SerializedName("avatar_url")
    private String ImageUrl;

    public UserProfile(String name, String imageUrl){
        this.mName = name;
        this.ImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }


    public String getImageUrl() {
        return ImageUrl;
    }

}
