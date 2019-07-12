package com.example.mvp.view.main;

import com.example.mvp.BaseContract;
import com.example.mvp.item.UserProfile;

import java.util.ArrayList;

public interface MainContract {
    interface View extends BaseContract.View  {

        // 아이템을 어댑터에 연결해 줍니다.
        void setItems(ArrayList<UserProfile> items);

    }

    interface Presenter extends BaseContract.Presenter<View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();

        // API 통신을 통해 데이터를 받아옵니다.
        void loadData();

    }
}
