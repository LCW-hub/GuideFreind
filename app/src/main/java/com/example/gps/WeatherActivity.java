package com.example.gps;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gps.api.WeatherApi;
import com.example.gps.model.WeatherInfo;
import com.example.gps.model.WeatherForecast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherActivity extends AppCompatActivity {

    private TextView tvTemperature, tvWeatherStatus, tvHumidity, tvWindSpeed;
    private RecyclerView rvForecast;
    private WeatherForecastAdapter forecastAdapter;
    private static final String WEATHER_API_KEY = "7a4aa78797771aa887fe9b14a9be94e5";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // 툴바 설정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("날씨 정보");

        // 뷰 초기화
        tvTemperature = findViewById(R.id.tvTemperature);
        tvWeatherStatus = findViewById(R.id.tvWeatherStatus);
        tvHumidity = findViewById(R.id.tvHumidity);
        tvWindSpeed = findViewById(R.id.tvWindSpeed);
        rvForecast = findViewById(R.id.rvForecast);

        // RecyclerView 설정
        rvForecast.setLayoutManager(new LinearLayoutManager(this));
        forecastAdapter = new WeatherForecastAdapter();
        rvForecast.setAdapter(forecastAdapter);

        // Retrofit 설정
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
            
        WeatherApi weatherApi = retrofit.create(WeatherApi.class);
        
        // 현재 날씨 정보 요청
        Call<WeatherInfo> currentWeatherCall = weatherApi.getWeather("Seoul", WEATHER_API_KEY);
        currentWeatherCall.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherInfo weather = response.body();
                    updateWeatherUI(weather);
                } else {
                    Toast.makeText(WeatherActivity.this, "날씨 정보를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
            
            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(WeatherActivity.this, "네트워크 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 5일 예보 정보 요청
        Call<WeatherForecast> forecastCall = weatherApi.getWeatherForecast("Seoul", WEATHER_API_KEY);
        forecastCall.enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherForecast forecast = response.body();
                    forecastAdapter.setForecastItems(forecast.getForecastItems());
                } else {
                    Toast.makeText(WeatherActivity.this, "예보 정보를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {
                Toast.makeText(WeatherActivity.this, "네트워크 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateWeatherUI(WeatherInfo weather) {
        tvTemperature.setText(String.format("%.1f°C", weather.getMain().getTemp() - 273.15));
        tvWeatherStatus.setText(weather.getWeather().get(0).getDescription());
        tvHumidity.setText(String.format("습도: %d%%", weather.getMain().getHumidity()));
        tvWindSpeed.setText(String.format("풍속: %.1f m/s", weather.getWind().getSpeed()));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
} 