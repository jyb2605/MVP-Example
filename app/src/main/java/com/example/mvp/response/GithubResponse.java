package com.example.mvp.response;

import com.example.mvp.item.GithubUserData;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubResponse extends BaseResponse{

    @SerializedName("total_count")
    private int count;

    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    @SerializedName("items")
    private ArrayList<GithubUserData> result;

    public ArrayList<GithubUserData> getResult() {
        return result;
    }
}
