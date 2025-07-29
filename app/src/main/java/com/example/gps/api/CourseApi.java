package com.example.gps.api;

import com.example.gps.model.CourseDetail;
import com.example.gps.model.CourseRecommendation;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CourseApi {
    private static final String BASE_URL = "https://your-api-server.com/api";
    
    // 코스 상세 정보 가져오기
    public static CourseDetail getCourseDetail(int courseId) {
        try {
            URL url = new URL(BASE_URL + "/courses/" + courseId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            JSONObject json = new JSONObject(response.toString());
            return parseCourseDetail(json);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // 추천 코스 목록 가져오기
    public static List<CourseRecommendation> getRecommendedCourses(String season, String weather, int crowdLevel) {
        try {
            String params = String.format("?season=%s&weather=%s&crowdLevel=%d", season, weather, crowdLevel);
            URL url = new URL(BASE_URL + "/courses/recommendations" + params);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            JSONArray jsonArray = new JSONArray(response.toString());
            List<CourseRecommendation> recommendations = new ArrayList<>();
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                recommendations.add(parseCourseRecommendation(json));
            }
            
            return recommendations;
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    // 유동인구 정보 업데이트
    public static boolean updateCrowdLevel(int courseId, int crowdLevel) {
        try {
            URL url = new URL(BASE_URL + "/courses/" + courseId + "/crowd");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            
            JSONObject body = new JSONObject();
            body.put("crowdLevel", crowdLevel);
            
            conn.getOutputStream().write(body.toString().getBytes());
            
            return conn.getResponseCode() == 200;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private static CourseDetail parseCourseDetail(JSONObject json) {
        CourseDetail course = new CourseDetail();
        course.setCourseId(json.getInt("courseId"));
        course.setCourseName(json.getString("courseName"));
        course.setDescription(json.getString("description"));
        course.setDistance(json.getDouble("distance"));
        course.setDuration(json.getInt("duration"));
        course.setSteps(json.getInt("steps"));
        course.setPetFriendly(json.getBoolean("petFriendly"));
        course.setCalories(json.getDouble("calories"));
        course.setWaterIntake(json.getDouble("waterIntake"));
        course.setDifficulty(json.getString("difficulty"));
        course.setCrowdLevel(json.getInt("crowdLevel"));
        course.setRating(json.getDouble("rating"));
        course.setReviewCount(json.getInt("reviewCount"));
        
        return course;
    }
    
    private static CourseRecommendation parseCourseRecommendation(JSONObject json) {
        CourseRecommendation recommendation = new CourseRecommendation();
        recommendation.setCourseId(json.getInt("courseId"));
        recommendation.setCourseName(json.getString("courseName"));
        recommendation.setRecommendationScore(json.getDouble("recommendationScore"));
        recommendation.setReason(json.getString("reason"));
        recommendation.setSeason(json.getString("season"));
        recommendation.setWeather(json.getString("weather"));
        recommendation.setCrowdLevel(json.getInt("crowdLevel"));
        recommendation.setFestival(json.getBoolean("isFestival"));
        
        if (recommendation.isFestival()) {
            recommendation.setFestivalName(json.getString("festivalName"));
            recommendation.setFestivalPeriod(json.getString("festivalPeriod"));
        }
        
        return recommendation;
    }
} 