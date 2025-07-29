package com.example.gps;

import android.app.Application;
import com.google.firebase.FirebaseApp;

public class GuideFriendApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            FirebaseApp.initializeApp(this);
        } catch (Exception e) {
            // Firebase 초기화 실패 시 로그 출력
            e.printStackTrace();
        }
    }
} 