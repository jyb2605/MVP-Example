package com.example.mvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.mvp.adapter.MyAdapter;
import com.example.mvp.item.GithubUserData;
import com.example.mvp.item.UserProfile;
import com.example.mvp.response.GithubResponse;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private ArrayList<GithubUserData> mList;
    private ArrayList<UserProfile> mUserProfiles = new ArrayList<>();

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(this, mUserProfiles);
        recyclerView.setAdapter(mAdapter);

        onSearch(randomAlphaNumeric(3));
    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public void onSearch(String search){
        Call<GithubResponse> res = NetRetrofit.getInstance().getService().getUserList(search);
        res.enqueue(new Callback<GithubResponse>(){

            @Override
            public void onResponse(@NonNull Call<GithubResponse> call, @NonNull Response<GithubResponse> response) {
                Log.d("Retrofit", response.toString());
                if(response.body() != null){
                    mList = response.body().getResult();
                    for(GithubUserData list : mList){
                        mUserProfiles.add(new UserProfile(list.getLogin(), list.getAvatar_url()));
                    }
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GithubResponse> call, @NonNull Throwable t) {
                Log.e("Retrofit Error", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
