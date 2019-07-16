package com.example.mvp.view.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.adapter.MyAdapter;
import com.example.mvp.item.UserProfile;
import com.example.mvp.view.main.MainActivity;

import java.util.ArrayList;

@SuppressLint("Registered")
public class SplashActivity extends AppCompatActivity implements SplashContract.View {
    private Handler mHandler;
    private SplashPresenter mPresenter;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SplashPresenter();

        mPresenter.setView(this);
        mHandler = new Handler();

        mPresenter.playAnimation((TextView) findViewById(R.id.tvTitle));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mIntent);
            }
        }).start();

    }

    @Override
    public Handler getHandler() {
        return mHandler;
    }
}
