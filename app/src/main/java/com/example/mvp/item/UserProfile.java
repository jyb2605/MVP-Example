package com.example.mvp.item;

public class UserProfile {
    private String mName;
    private String ImageUrl;

    public UserProfile(String name, String imageUrl){
        this.mName = name;
        this.ImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.ImageUrl = imageUrl;
    }
}
