package com.example.gps.model;

import java.util.List;

public class CourseRecommendation {
    private int courseId;
    private String courseName;
    private double recommendationScore; // 0.0 ~ 1.0
    private String reason; // 추천 이유
    private List<String> tags; // 추천 태그
    private String season;
    private String weather;
    private int crowdLevel;
    private boolean isFestival; // 축제 기간 여부
    private String festivalName; // 축제명
    private String festivalPeriod; // 축제 기간

    public CourseRecommendation() {}

    public CourseRecommendation(int courseId, String courseName, double recommendationScore, 
                               String reason, String season, String weather, int crowdLevel) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.recommendationScore = recommendationScore;
        this.reason = reason;
        this.season = season;
        this.weather = weather;
        this.crowdLevel = crowdLevel;
    }

    // Getters and Setters
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public double getRecommendationScore() { return recommendationScore; }
    public void setRecommendationScore(double recommendationScore) { this.recommendationScore = recommendationScore; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public String getWeather() { return weather; }
    public void setWeather(String weather) { this.weather = weather; }

    public int getCrowdLevel() { return crowdLevel; }
    public void setCrowdLevel(int crowdLevel) { this.crowdLevel = crowdLevel; }

    public boolean isFestival() { return isFestival; }
    public void setFestival(boolean festival) { isFestival = festival; }

    public String getFestivalName() { return festivalName; }
    public void setFestivalName(String festivalName) { this.festivalName = festivalName; }

    public String getFestivalPeriod() { return festivalPeriod; }
    public void setFestivalPeriod(String festivalPeriod) { this.festivalPeriod = festivalPeriod; }
} 