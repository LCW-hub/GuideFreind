package com.example.gps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.firebase.FirebaseApp;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000; // 3초로 증가
=======
import androidx.core.content.ContextCompat;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 2000; // 2초
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD

=======
        
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
        // 상태바 투명하게 설정
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
        window.setNavigationBarColor(ContextCompat.getColor(this, android.R.color.transparent));
        
        setContentView(R.layout.activity_splash);

<<<<<<< HEAD
        // UI 요소들 찾기
        CardView cardLogo = findViewById(R.id.cardLogo);
        ImageView ivLogo = findViewById(R.id.ivLogo);
        TextView tvAppName = findViewById(R.id.tvAppName);
        TextView tvSubTitle = findViewById(R.id.tvSubTitle);
        TextView tvLoading = findViewById(R.id.tvLoading);
        CircularProgressIndicator progressIndicator = findViewById(R.id.progressIndicator);
        
        // 자연 요소 아이콘들
        ImageView ivNature1 = findViewById(R.id.ivNature1);
        ImageView ivNature2 = findViewById(R.id.ivNature2);
        ImageView ivNature3 = findViewById(R.id.ivNature3);
        ImageView ivNature4 = findViewById(R.id.ivNature4);

        // 애니메이션 로드
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        Animation bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // 로고 카드 애니메이션 (페이드인 + 슬라이드업)
        cardLogo.startAnimation(fadeIn);
        cardLogo.startAnimation(slideUp);
        
        // 로고 회전 애니메이션
        ivLogo.startAnimation(rotate);
        
        // 텍스트 애니메이션 (지연 후 페이드인)
        new Handler().postDelayed(() -> {
            tvAppName.startAnimation(fadeIn);
        }, 500);
        
        new Handler().postDelayed(() -> {
            tvSubTitle.startAnimation(fadeIn);
        }, 1000);
        
        new Handler().postDelayed(() -> {
            tvLoading.startAnimation(fadeIn);
            progressIndicator.startAnimation(fadeIn);
        }, 1500);

        // 자연 요소 아이콘들 애니메이션
        new Handler().postDelayed(() -> {
            ivNature1.startAnimation(bounce);
        }, 200);
        
        new Handler().postDelayed(() -> {
            ivNature2.startAnimation(bounce);
        }, 400);
        
        new Handler().postDelayed(() -> {
            ivNature3.startAnimation(bounce);
        }, 600);
        
        new Handler().postDelayed(() -> {
            ivNature4.startAnimation(bounce);
        }, 800);

        // 3초 후 메인 화면으로 전환
=======
        // 애니메이션 적용
        ImageView ivLogo = findViewById(R.id.ivLogo);
        TextView tvAppName = findViewById(R.id.tvAppName);
        TextView tvSubTitle = findViewById(R.id.tvSubTitle);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        ivLogo.startAnimation(fadeIn);
        tvAppName.startAnimation(fadeIn);
        tvSubTitle.startAnimation(fadeIn);

        // 2초 후 메인 화면으로 전환
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MapsActivity.class));
            finish();
        }, SPLASH_DURATION);
    }
} 