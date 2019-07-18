package com.example.mvp.item;

import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @SerializedName("login")
    private String mName;

    @SerializedName("avatar_url")
    private String ImageUrl;

    @SerializedName("score")
    private double score;

    public UserProfile(String name, String imageUrl, double score){
        this.mName = name;
        this.ImageUrl = imageUrl;
        this.score = score;
    }

    public String getName() {
        return mName;
    }


    public String getImageUrl() {
        return ImageUrl;
    }

    public double getScore() {
        return score;
    }
}
