package com.example.mvp;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/search/users")
    Call<ArrayList<JsonObject>> getListRepos(@Path("q") String search);
}
