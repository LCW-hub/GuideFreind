package com.example.gps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gps.model.CourseRecommendation;
import com.example.gps.api.CourseApi;
import com.example.gps.api.WeatherApi;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecommendationActivity extends AppCompatActivity {
    
    private Spinner spinnerSeason, spinnerWeather, spinnerCrowd;
    private Button btnGetRecommendations, btnAutoDetect;
    private RecyclerView recyclerView;
    private TextView tvNoRecommendations;
    private RecommendationAdapter adapter;
    private List<CourseRecommendation> recommendations = new ArrayList<>();
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        
        initViews();
        setupRecyclerView();
        setupButtons();
    }
    
    private void initViews() {
        spinnerSeason = findViewById(R.id.spinner_season);
        spinnerWeather = findViewById(R.id.spinner_weather);
        spinnerCrowd = findViewById(R.id.spinner_crowd);
        btnGetRecommendations = findViewById(R.id.btn_get_recommendations);
        btnAutoDetect = findViewById(R.id.btn_auto_detect);
        recyclerView = findViewById(R.id.recycler_recommendations);
        tvNoRecommendations = findViewById(R.id.tv_no_recommendations);
    }
    
    private void setupRecyclerView() {
        adapter = new RecommendationAdapter(recommendations, courseId -> {
            // 코스 상세 정보로 이동
            Intent intent = new Intent(this, CourseDetailActivity.class);
            intent.putExtra("course_id", courseId);
            startActivity(intent);
        });
        
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    
    private void setupButtons() {
        btnGetRecommendations.setOnClickListener(v -> {
            String season = spinnerSeason.getSelectedItem().toString();
            String weather = spinnerWeather.getSelectedItem().toString();
            int crowdLevel = spinnerCrowd.getSelectedItemPosition() + 1;
            
            loadRecommendations(season, weather, crowdLevel);
        });
        
        btnAutoDetect.setOnClickListener(v -> {
            // 현재 위치의 날씨와 계절을 자동으로 감지
            autoDetectConditions();
        });
    }
    
    private void loadRecommendations(String season, String weather, int crowdLevel) {
        btnGetRecommendations.setEnabled(false);
        btnGetRecommendations.setText("추천 중...");
        
        executor.execute(() -> {
            List<CourseRecommendation> newRecommendations = 
                CourseApi.getRecommendedCourses(season, weather, crowdLevel);
            
            runOnUiThread(() -> {
                btnGetRecommendations.setEnabled(true);
                btnGetRecommendations.setText("추천받기");
                
                if (!newRecommendations.isEmpty()) {
                    recommendations.clear();
                    recommendations.addAll(newRecommendations);
                    adapter.notifyDataSetChanged();
                    recyclerView.setVisibility(View.VISIBLE);
                    tvNoRecommendations.setVisibility(View.GONE);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    tvNoRecommendations.setVisibility(View.VISIBLE);
                    tvNoRecommendations.setText("조건에 맞는 추천 코스가 없습니다.");
                }
            });
        });
    }
    
    private void autoDetectConditions() {
        btnAutoDetect.setEnabled(false);
        btnAutoDetect.setText("감지 중...");
        
        executor.execute(() -> {
            try {
                // 현재 위치의 날씨 정보 가져오기
                // WeatherApi.getCurrentWeather() 호출
                
                runOnUiThread(() -> {
                    // 실제 구현에서는 날씨 API에서 받은 정보로 스피너 설정
                    // 예시로 봄, 맑음, 보통으로 설정
                    spinnerSeason.setSelection(0); // 봄
                    spinnerWeather.setSelection(0); // 맑음
                    spinnerCrowd.setSelection(2); // 보통
                    
                    btnAutoDetect.setEnabled(true);
                    btnAutoDetect.setText("자동 감지");
                    
                    Toast.makeText(RecommendationActivity.this, 
                        "현재 조건으로 자동 설정되었습니다.", Toast.LENGTH_SHORT).show();
                });
                
            } catch (Exception e) {
                runOnUiThread(() -> {
                    btnAutoDetect.setEnabled(true);
                    btnAutoDetect.setText("자동 감지");
                    Toast.makeText(RecommendationActivity.this, 
                        "자동 감지에 실패했습니다.", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.shutdown();
    }
    
    // 추천 코스 어댑터
    private static class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.ViewHolder> {
        private List<CourseRecommendation> recommendations;
        private OnCourseClickListener listener;
        
        public interface OnCourseClickListener {
            void onCourseClick(int courseId);
        }
        
        public RecommendationAdapter(List<CourseRecommendation> recommendations, OnCourseClickListener listener) {
            this.recommendations = recommendations;
            this.listener = listener;
        }
        
        @Override
        public ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
            View view = android.view.LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommendation, parent, false);
            return new ViewHolder(view);
        }
        
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            CourseRecommendation recommendation = recommendations.get(position);
            
            holder.tvCourseName.setText(recommendation.getCourseName());
            holder.tvScore.setText(String.format("추천도: %.1f%%", recommendation.getRecommendationScore() * 100));
            holder.tvReason.setText(recommendation.getReason());
            holder.tvConditions.setText(String.format("계절: %s, 날씨: %s, 유동인구: %d/5", 
                recommendation.getSeason(), recommendation.getWeather(), recommendation.getCrowdLevel()));
            
            if (recommendation.isFestival()) {
                holder.tvFestival.setVisibility(View.VISIBLE);
                holder.tvFestival.setText(String.format("🎉 %s (%s)", 
                    recommendation.getFestivalName(), recommendation.getFestivalPeriod()));
            } else {
                holder.tvFestival.setVisibility(View.GONE);
            }
            
            holder.itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onCourseClick(recommendation.getCourseId());
                }
            });
        }
        
        @Override
        public int getItemCount() {
            return recommendations.size();
        }
        
        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvCourseName, tvScore, tvReason, tvConditions, tvFestival;
            
            ViewHolder(View itemView) {
                super(itemView);
                tvCourseName = itemView.findViewById(R.id.tv_course_name);
                tvScore = itemView.findViewById(R.id.tv_score);
                tvReason = itemView.findViewById(R.id.tv_reason);
                tvConditions = itemView.findViewById(R.id.tv_conditions);
                tvFestival = itemView.findViewById(R.id.tv_festival);
            }
        }
    }
} 