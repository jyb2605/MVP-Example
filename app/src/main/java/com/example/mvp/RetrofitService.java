package com.example.mvp;

import com.example.mvp.response.GithubResponse;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/search/users")
    Call<GithubResponse> getUserList(@Query("q") String search);
}
