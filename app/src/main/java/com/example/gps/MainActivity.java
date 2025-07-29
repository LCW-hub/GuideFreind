package com.example.gps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
=======
import android.widget.Button;
import android.widget.EditText;
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gps.api.ApiClient;
import com.example.gps.api.UserApi;
import com.example.gps.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, emailEditText, nameEditText;
    private Button signupButton;
<<<<<<< HEAD
    private ImageView ivNatureTop1, ivNatureTop2, ivNatureBottom1, ivNatureBottom2, 
                     ivNatureBottom3, ivNatureBottom4;
=======
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        
        // UI 요소들 초기화
=======
        setContentView(R.layout.activity_main);

>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        emailEditText = findViewById(R.id.editTextEmail);
        nameEditText = findViewById(R.id.editTextName);
        signupButton = findViewById(R.id.buttonSignup);
<<<<<<< HEAD
        
        // 자연 요소 아이콘들
        ivNatureTop1 = findViewById(R.id.ivNatureTop1);
        ivNatureTop2 = findViewById(R.id.ivNatureTop2);
        ivNatureBottom1 = findViewById(R.id.ivNatureBottom1);
        ivNatureBottom2 = findViewById(R.id.ivNatureBottom2);
        ivNatureBottom3 = findViewById(R.id.ivNatureBottom3);
        ivNatureBottom4 = findViewById(R.id.ivNatureBottom4);
=======
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd

        // 기본값 자동 입력
        usernameEditText.setText("testuser");
        passwordEditText.setText("1234");
        emailEditText.setText("test@example.com");
        nameEditText.setText("홍길동");

<<<<<<< HEAD
        // 자연 요소 아이콘들 애니메이션
        startNatureAnimations();

=======
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
        // 강제 실행
        signup();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

<<<<<<< HEAD
    private void startNatureAnimations() {
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        
        // 상단 자연 요소들
        ivNatureTop1.startAnimation(fadeIn);
        ivNatureTop2.startAnimation(fadeIn);
        
        // 하단 자연 요소들 (지연 애니메이션)
        new android.os.Handler().postDelayed(() -> {
            ivNatureBottom1.startAnimation(bounce);
        }, 200);
        
        new android.os.Handler().postDelayed(() -> {
            ivNatureBottom2.startAnimation(bounce);
        }, 400);
        
        new android.os.Handler().postDelayed(() -> {
            ivNatureBottom3.startAnimation(slideUp);
        }, 600);
        
        new android.os.Handler().postDelayed(() -> {
            ivNatureBottom4.startAnimation(slideUp);
        }, 800);
    }
=======
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd

    private void signup() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String name = nameEditText.getText().toString();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "모든 필드를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show();

        // ✅ MapsActivity로 이동
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
        finish(); // 현재 액티비티 종료 (선택)
    }
<<<<<<< HEAD
=======


>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
}


