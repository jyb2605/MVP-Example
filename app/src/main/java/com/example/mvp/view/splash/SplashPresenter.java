package com.example.mvp.view.splash;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mvp.NetRetrofit;
import com.example.mvp.R;
import com.example.mvp.response.GithubResponse;
import com.example.mvp.view.main.MainActivity;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Thread.sleep;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View view;
    private TextView tvTitle;

    @Override
    public void setView(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public void releaseView() {

    }

    @Override
    public void playAnimation(TextView tvT) {
        final Handler handler = view.getHandler();
        tvTitle = tvT;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void run() {
                        Log.d("Presenter", "End Waiting");
                        tvTitle.setTextColor(Color.parseColor("#EC1111"));
                    }
                });
            }
        }).start();
    }
}
