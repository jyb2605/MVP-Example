package com.example.mvp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetRetrofit {
    private static NetRetrofit ourInstance = new NetRetrofit();
    public static NetRetrofit getInstance() {
        return ourInstance;
    }
    private NetRetrofit() {
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create()) // 파싱등록
            .build();

    private RetrofitService service = retrofit.create(RetrofitService.class);

    public RetrofitService getService() {
        return service;
    }
}
