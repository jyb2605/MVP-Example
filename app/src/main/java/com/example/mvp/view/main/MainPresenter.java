package com.example.mvp.view.main;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mvp.NetRetrofit;
import com.example.mvp.response.GithubResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void releaseView() {

    }

    @Override
    public void loadData() {
        onSearch(randomAlphaNumeric(3));
    }


    public void onSearch(String search){
        Call<GithubResponse> res = NetRetrofit.getInstance().getService().getUserList(search);
        res.enqueue(new Callback<GithubResponse>(){

            @Override
            public void onResponse(@NonNull Call<GithubResponse> call, @NonNull Response<GithubResponse> response) {
                Log.d("Retrofit", response.toString());
                if(response.body() != null){
                    view.setItems(response.body().getResult());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GithubResponse> call, @NonNull Throwable t) {
                Log.e("Retrofit Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
