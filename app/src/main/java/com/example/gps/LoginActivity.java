//로그인 화면
package com.example.gps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gps.api.ApiClient;
import com.example.gps.api.UserApi;
import com.example.gps.model.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etId, etPw;
    private Button btnLogin, btnGuest;
    private TextView tvSignup, tvFindId, tvFindPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 툴바 설정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("로그인");

        // XML에서 뷰 연결
        etId = findViewById(R.id.etId);
        etPw = findViewById(R.id.etPw);
        btnLogin = findViewById(R.id.btnLogin);
        btnGuest = findViewById(R.id.btnGuest);
        tvSignup = findViewById(R.id.tvSignup);
        tvFindId = findViewById(R.id.tvFindId);
        tvFindPw = findViewById(R.id.tvFindPw);

        // 로그인 버튼 클릭
        btnLogin.setOnClickListener(view -> login());

        // 회원가입 화면으로 이동
        tvSignup.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // 아이디 찾기 화면 이동
        tvFindId.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, FindIdActivity.class);
            startActivity(intent);
        });

        // 비밀번호 찾기 화면 이동
        tvFindPw.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, FindPwActivity.class);
            startActivity(intent);
        });

        // 비회원 모드 (게스트 로그인)
        btnGuest.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
            startActivity(intent);
            Toast.makeText(this, "🚶 게스트 모드로 시작합니다!", Toast.LENGTH_SHORT).show();
        });
    }

    private void login() {
        String id = etId.getText().toString().trim();
        String pw = etPw.getText().toString().trim();

        // 입력 유효성 검사
        if (id.isEmpty()) {
            etId.setError("아이디를 입력해주세요");
            etId.requestFocus();
            return;
        }

        if (pw.isEmpty()) {
            etPw.setError("비밀번호를 입력해주세요");
            etPw.requestFocus();
            return;
        }

        // ✅ 관리자 계정 체크
        if (id.equals("admin") && pw.equals("1234")) {
            Toast.makeText(this, "🔑 관리자 로그인 성공!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, AdminMain.class);
            startActivity(intent);
            finish();
        } else {
            // ✅ 일반 회원 로그인 (서버에 요청)
            User user = new User(id, pw, null, null);

            UserApi userApi = ApiClient.getClient().create(UserApi.class);
            Call<Map<String, String>> call = userApi.login(user);

            call.enqueue(new Callback<Map<String, String>>() {
                @Override
                public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        String status = response.body().get("status");
                        String message = response.body().get("message");

                        Toast.makeText(LoginActivity.this, "✨ " + message, Toast.LENGTH_SHORT).show();

                        if ("success".equals(status)) {
                            Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "❌ 서버 응답 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Map<String, String>> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "🌐 네트워크 오류: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
