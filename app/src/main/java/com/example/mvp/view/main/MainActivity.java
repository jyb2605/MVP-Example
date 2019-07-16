package com.example.mvp.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvp.R;
import com.example.mvp.adapter.MyAdapter;
import com.example.mvp.item.UserProfile;

import java.util.ArrayList;

@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MyAdapter mAdapter;
    private MainPresenter mPresenter = new MainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.setView(this);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(this);
        recyclerView.setAdapter(mAdapter);

        findViewById(R.id.btnSearch)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText etQuery = findViewById(R.id.etQuery);
                        mPresenter.loadData(etQuery.getText().toString());
                    }
                });

//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    mPresenter.loadData();
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


    }

    @Override
    public void setItems(ArrayList<UserProfile> list) {
        mAdapter.setData(list);
        mAdapter.notifyDataSetChanged();
    }
}
