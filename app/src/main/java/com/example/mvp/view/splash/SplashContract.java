package com.example.mvp.view.splash;

import android.os.Handler;
import android.widget.TextView;

import com.example.mvp.BaseContract;
import com.example.mvp.item.UserProfile;

import java.util.ArrayList;

public interface SplashContract {
    interface View extends BaseContract.View  {

        Handler getHandler();

    }

    interface Presenter extends BaseContract.Presenter<View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();

        void playAnimation(TextView tvTitle);


    }
}
