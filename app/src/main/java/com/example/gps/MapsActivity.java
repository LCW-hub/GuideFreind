package com.example.gps;

<<<<<<< HEAD
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.PathOverlay;
import com.naver.maps.map.util.FusedLocationSource;
=======
import android.content.Intent;
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
<<<<<<< HEAD
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.PopupMenu;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
=======
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.naver.maps.geometry.LatLng;
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
<<<<<<< HEAD
import com.naver.maps.map.overlay.OverlayImage;
import org.json.JSONArray;
import org.json.JSONObject;
=======
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.overlay.PathOverlay;
import com.naver.maps.map.util.FusedLocationSource;

import org.json.JSONArray;
import org.json.JSONObject;

>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
<<<<<<< HEAD
import android.view.animation.AccelerateDecelerateInterpolator;
=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private NaverMap naverMap;
    private FusedLocationSource locationSource;
    private final List<PathOverlay> pathOverlays = new ArrayList<>();
    private DangerZoneManager dangerZoneManager;
    private FacilityManager facilityManager;

<<<<<<< HEAD
    private androidx.cardview.widget.CardView courseInfoPanel;
=======
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private LinearLayout buttonsLayout;
    private LinearLayout courseButtonsLayout;
    private LinearLayout courseInfoPanel;
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
    
    // 메뉴 관련 - 설정 메뉴만 유지
    private Menu optionsMenu;
    
    // 코스 정보 패널 뷰들
    private TextView courseTitle;
    private TextView courseRecommendation;
    private TextView courseDistance;
    private TextView courseDuration;
    private TextView courseDifficulty;
    private TextView courseDescription;
    private Button btnCloseInfo;
<<<<<<< HEAD
=======
    private Button btnCourseSelector; // 코스 선택 버튼
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String TMAP_API_KEY = "6BXu3W092c8kdbZVOOzDe5YqlALysG305fjlKG10";

    private JSONArray coursesJSON;
    private final List<Marker> activeMarkers = new ArrayList<>();
    
    // API 캐싱 및 제어를 위한 변수들
    private final Map<String, List<LatLng>> routeCache = new HashMap<>();
    private final AtomicInteger pendingApiCalls = new AtomicInteger(0);
    private static final int MAX_CONCURRENT_API_CALLS = 2; // 동시 API 호출 제한 더 엄격하게
    private static final long API_DELAY_MS = 500; // API 호출 간격 증가 (500ms)
    private static final int MAX_RETRY_COUNT = 3; // 최대 재시도 횟수
    
    // 드래그 관련 변수들
    private float initialTouchY;
    private float initialPanelY;
    private boolean isDragging = false;
    private static final float PANEL_VISIBLE_Y = 0f;
    private static final float DRAG_THRESHOLD = 80f; // 드래그 임계값 조정
    
    // 코스별 패널 숨김 위치 (각 코스의 패널 높이에 맞춰 조정)
    private static final float[] PANEL_HIDDEN_Y_VALUES = {
        745f,  // 1코스 - 핸들 부분만 보이도록 큰 값으로 조정
        680f,  // 2코스 - 중간 길이 설명에 맞춰 조정
<<<<<<< HEAD
        800f,  // 3코스 - 긴 설명에 맞춰 가장 크게 조정
        750f,  // 북한산 1코스 - 도봉산 코스
        780f,  // 북한산 2코스 - 우이동 코스
        820f   // 북한산 3코스 - 정릉 코스
    };
    
    private int currentCourseIndex = -1; // 현재 선택된 코스 인덱스 (-1: 메인, 0-2: 남한산성 코스, 3-5: 북한산 코스)
=======
        800f   // 3코스 - 긴 설명에 맞춰 가장 크게 조정
    };
    
    private int currentCourseIndex = -1; // 현재 선택된 코스 인덱스
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
    
    // 코스별 정보 데이터
    private static class CourseInfo {
        String title;
        String recommendation;
        String distance;
        String duration;
        String difficulty;
        String description;
        int titleColor;
        
        CourseInfo(String title, String recommendation, String distance, String duration, 
                  String difficulty, String description, int titleColor) {
            this.title = title;
            this.recommendation = recommendation;
            this.distance = distance;
            this.duration = duration;
            this.difficulty = difficulty;
            this.description = description;
            this.titleColor = titleColor;
        }
    }
    
    private CourseInfo[] courseInfos = {
<<<<<<< HEAD
        // 남한산성 코스들
=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
        new CourseInfo(
            "둘레길 1코스 - 역사 탐방길",
            "👨‍👩‍👧‍👦 가족 단위, 초보자 추천",
            "📏 거리: 3.2km",
<<<<<<< HEAD
            "⏱️ 소요시간: 1시간30분",
=======
            "⏱️ 소요시간: 1.5시간",
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
            "⭐ 난이도: 쉬움",
            "남한산성의 대표적인 입문 코스로, 주요 성문과 역사적 건물들을 둘러볼 수 있습니다. 경사가 완만하여 어린이나 어르신도 부담 없이 걸을 수 있으며, 조선시대 역사와 문화를 체험할 수 있는 최적의 코스입니다.",
            0xFFFF5722
        ),
        new CourseInfo(
            "둘레길 2코스 - 문화 체험길",
            "🎭 중급자, 문화 애호가 추천",
            "📏 거리: 2.8km",
            "⏱️ 소요시간: 2시간",
            "⭐⭐ 난이도: 보통",
            "남한산성의 문화유산을 집중적으로 탐방할 수 있는 코스입니다. 영월정, 수어장대 등 조선시대 건축물과 국청사, 숭렬전 등 역사적 의미가 깊은 장소들을 만날 수 있어 역사 공부에 최적입니다.",
            0xFF2196F3
        ),
        new CourseInfo(
            "둘레길 3코스 - 자연 힐링길",
            "🏔️ 고급자, 자연 애호가 추천",
            "📏 거리: 4.1km",
<<<<<<< HEAD
            "⏱️ 소요시간: 2시간30분",
            "⭐⭐⭐ 난이도: 어려움",
            "남한산성의 자연경관을 만끽할 수 있는 코스입니다. 벌봉 정상에서의 탁 트인 전망과 깊은 숲길, 계곡을 따라 걸으며 사계절 아름다운 자연을 느낄 수 있습니다. 체력적으로 도전적이지만 그만큼 큰 만족감을 줍니다.",
            0xFF4CAF50
        ),
        // 북한산 코스들
        new CourseInfo(
            "북한산 둘레길 1코스 - 도봉산 코스",
            "🌲 초보자, 가족 단위 추천",
            "📏 거리: 2.5km",
            "⏱️ 소요시간: 1시간",
            "⭐ 난이도: 쉬움",
            "북한산의 가장 접근하기 쉬운 코스로, 도봉산역에서 시작하여 완만한 경사로 구성되어 있습니다. 도봉산의 아름다운 자연을 감상하면서도 부담 없이 산행을 즐길 수 있는 코스입니다.",
            0xFF9C27B0
        ),
        new CourseInfo(
            "북한산 둘레길 2코스 - 우이동 코스",
            "🏃‍♂️ 중급자, 등산 애호가 추천",
            "📏 거리: 4.2km",
            "⏱️ 소요시간: 2시간30분",
            "⭐⭐ 난이도: 보통",
            "우이동에서 시작하는 북한산의 대표적인 코스입니다. 깊은 숲길과 바위길을 거쳐 북한산의 다양한 자연경관을 만날 수 있습니다. 중간 난이도로 적당한 도전감을 느낄 수 있는 코스입니다.",
            0xFFFF9800
        ),
        new CourseInfo(
            "북한산 둘레길 3코스 - 정릉 코스",
            "⛰️ 고급자, 정상 정복 추천",
            "📏 거리: 6.8km",
            "⏱️ 소요시간: 4시간",
            "⭐⭐⭐ 난이도: 어려움",
            "북한산 정상까지 오르는 가장 도전적인 코스입니다. 가파른 바위길과 험난한 구간을 거쳐 북한산 정상에서 서울의 탁 트인 전경을 감상할 수 있습니다. 체력과 등산 경험이 필요한 고난도 코스입니다.",
            0xFF795548
        )
    };

    private boolean isDangerZonesVisible = true;
    private boolean isFacilitiesVisible = true;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

=======
            "⏱️ 소요시간: 2.5시간",
            "⭐⭐⭐ 난이도: 어려움",
            "남한산성의 자연경관을 만끽할 수 있는 코스입니다. 벌봉 정상에서의 탁 트인 전망과 깊은 숲길, 계곡을 따라 걸으며 사계절 아름다운 자연을 느낄 수 있습니다. 체력적으로 도전적이지만 그만큼 큰 만족감을 줍니다.",
            0xFF4CAF50
        )
    };

>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
        // DrawerLayout 초기화
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // NavigationView 설정
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            
            if (id == R.id.nav_login) {
                // 로그인 화면으로 이동
                Intent loginIntent = new Intent(this, LoginActivity.class);
                startActivity(loginIntent);
            } else if (id == R.id.nav_signup) {
                // 회원가입 화면으로 이동
                Intent signupIntent = new Intent(this, RegisterActivity.class);
                startActivity(signupIntent);
            } else if (id == R.id.nav_weather) {
                // 날씨 화면으로 이동
                Intent weatherIntent = new Intent(this, WeatherActivity.class);
                startActivity(weatherIntent);
            } else if (id == R.id.nav_community) {
                // 커뮤니티 화면으로 이동
                Intent communityIntent = new Intent(this, CommunityActivity.class);
                startActivity(communityIntent);
            } else if (id == R.id.nav_tips) {
                // 산책로 팁 화면으로 이동
                Intent tipsIntent = new Intent(this, TipsActivity.class);
                startActivity(tipsIntent);
            } else if (id == R.id.nav_favorites) {
                // 즐겨찾는 길 화면으로 이동
                Intent favoritesIntent = new Intent(this, FavoritesActivity.class);
                startActivity(favoritesIntent);
            } else if (id == R.id.nav_settings) {
                // 설정 메뉴는 아직 구현되지 않음
                Toast.makeText(this, "설정 기능은 준비 중입니다.", Toast.LENGTH_SHORT).show();
            }

            // 메뉴 선택 후 드로어 닫기
            drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        });

        // 지도 초기화
=======
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.right_drawer);
        buttonsLayout = findViewById(R.id.buttonsLayout);
        buttonsLayout.setVisibility(View.VISIBLE);
        courseButtonsLayout = findViewById(R.id.courseButtonsLayout);
        courseInfoPanel = findViewById(R.id.courseInfoPanel);

        // 코스 정보 패널 뷰 초기화
        courseTitle = findViewById(R.id.courseTitle);
        courseRecommendation = findViewById(R.id.courseRecommendation);
        courseDistance = findViewById(R.id.courseDistance);
        courseDuration = findViewById(R.id.courseDuration);
        courseDifficulty = findViewById(R.id.courseDifficulty);
        courseDescription = findViewById(R.id.courseDescription);
        btnCloseInfo = findViewById(R.id.btnCloseInfo);

        // 코스 선택 버튼 초기화
        btnCourseSelector = findViewById(R.id.btnCourseSelector);
        btnCourseSelector.setOnClickListener(v -> showCoursePopupMenu());

>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

<<<<<<< HEAD
        // 코스 정보 패널 초기화
        courseInfoPanel = findViewById(R.id.course_info_panel);
        courseTitle = findViewById(R.id.course_title);
        courseRecommendation = findViewById(R.id.course_recommendation);
        courseDistance = findViewById(R.id.course_distance);
        courseDuration = findViewById(R.id.course_duration);
        courseDifficulty = findViewById(R.id.course_difficulty);
        courseDescription = findViewById(R.id.course_description);
        btnCloseInfo = findViewById(R.id.btn_close_info);

        // 패널 드래그 설정
        setupPanelDrag();

        // 위험 구역 매니저 초기화
        dangerZoneManager = new DangerZoneManager();

        // 시설물 매니저 초기화
        facilityManager = new FacilityManager();

        // 코스 데이터 로드
        loadCoursesFromJSON();

        // 버튼 초기화 및 이벤트 설정
        Button btnAll = findViewById(R.id.btnAll);
        Button btnMyLocation = findViewById(R.id.btnMyLocation);
        Button btnSelectCourse = findViewById(R.id.btnSelectCourse);
        Button btnCourseDetail = findViewById(R.id.btnCourseDetail);
        Button btnRecommendation = findViewById(R.id.btnRecommendation);

        btnAll.setOnClickListener(v -> displayAllCourses());
        btnMyLocation.setOnClickListener(v -> moveToCurrentLocation());
        btnSelectCourse.setOnClickListener(v -> {
            // 현재 선택된 지역에 따라 다른 메뉴 표시
            if (currentCourseIndex >= 3) {
                // 북한산 코스 선택 팝업 메뉴 표시
                showBukhansanCourseMenu(v);
            } else {
                // 남한산성 코스 선택 팝업 메뉴 표시
                showNamhansanCourseMenu(v);
            }
        });
        
        btnCourseDetail.setOnClickListener(v -> {
            if (currentCourseIndex >= 0) {
                // 코스 상세 정보 액티비티로 이동
                Intent intent = new Intent(this, CourseDetailActivity.class);
                intent.putExtra("course_id", currentCourseIndex + 1);
                startActivity(intent);
            } else {
                Toast.makeText(this, "먼저 코스를 선택해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
        
        btnRecommendation.setOnClickListener(v -> {
            // 추천 시스템 액티비티로 이동
            Intent intent = new Intent(this, RecommendationActivity.class);
            startActivity(intent);
        });

        // 모든 btnCloseInfo.setText("코스1"), ... 부분을 아래로 교체
        btnCloseInfo.setText("닫기");
        // ... existing code ...
        // onCreate 등에서 btnCloseInfo 클릭 시 패널 닫기
        btnCloseInfo.setOnClickListener(v -> hideCourseInfoPanel());
        // ... existing code ...
=======
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

        // 서울로 돌아가기 버튼
        Button btnBackToSeoul = findViewById(R.id.btnBackToSeoul);
        btnBackToSeoul.setOnClickListener(v -> {
            // 서울 중심부로 부드럽게 이동
            CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                new LatLng(37.5665, 126.9780), 11)
                .animate(CameraAnimation.Easing, 1500);
            naverMap.moveCamera(cameraUpdate);
            
            // 기본 마커들만 다시 표시
            showMainMarkers();
            
            // 원형 버튼들과 정보 패널 완전히 숨기기
            courseButtonsLayout.setVisibility(View.GONE);
            courseInfoPanel.setVisibility(View.GONE);
            currentCourseIndex = -1; // 코스 인덱스 초기화
            
            // 코스 선택 버튼 숨기기
            btnCourseSelector.setVisibility(View.GONE);
            
            Toast.makeText(this, "서울로 돌아갑니다.", Toast.LENGTH_SHORT).show();
        });

        // 코스 정보 닫기 버튼
        btnCloseInfo.setOnClickListener(v -> hideCourseInfoPanel());

        // 코스 정보 패널 드래그 기능 초기화
        setupPanelDrag();

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_login) {
                startActivity(new Intent(this, LoginActivity.class));
            } else if (itemId == R.id.nav_register) {
                startActivity(new Intent(this, RegisterActivity.class));
            } else if (itemId == R.id.nav_weather) {
                startActivity(new Intent(this, WeatherActivity.class));
            } else if (itemId == R.id.nav_community) {
                startActivity(new Intent(this, CommunityActivity.class));
            } else if (itemId == R.id.nav_tips) {
                startActivity(new Intent(this, TipsActivity.class));
            } else if (itemId == R.id.nav_favorites) {
                startActivity(new Intent(this, FavoritesActivity.class));
            } else {
                Toast.makeText(this, "메뉴: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
            drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        });
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
    }

    @Override
    public void onMapReady(@NonNull NaverMap map) {
        naverMap = map;
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
        
<<<<<<< HEAD
=======
        dangerZoneManager = new DangerZoneManager();
        facilityManager = new FacilityManager();
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
        loadDangerZones();
        loadFacilities();

        loadCoursesFromJSON(); // JSON 먼저 로드

        // 초기 카메라 위치를 서울 중심부로 설정
        naverMap.moveCamera(CameraUpdate.scrollAndZoomTo(new LatLng(37.5665, 126.9780), 11));

        // 초기에 남한산성과 북한산 둘레길 마커만 표시
        showMainMarkers();

        naverMap.setOnMapClickListener((pointF, latLng) -> {
            String message = "클릭한 위치 - 위도: " + latLng.latitude + ", 경도: " + latLng.longitude;
            Toast.makeText(MapsActivity.this, message, Toast.LENGTH_SHORT).show();
            Log.d("MapClick", message);
        });
    }

    private void loadCoursesFromJSON() {
        try {
            InputStream is = getAssets().open("course_data.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            String jsonStr = new String(buffer, "UTF-8");

            JSONObject root = new JSONObject(jsonStr);
            coursesJSON = root.getJSONArray("courses");

        } catch (Exception e) {
            Log.e("JSON", "코스 불러오기 실패", e);
        }
    }

    private void loadDangerZones() {
        try {
            // 위험 구역 데이터 로드 (assets/danger_zones.json에서)
            InputStream is = getAssets().open("danger_zones.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            
            JSONArray dangerZones = new JSONArray(sb.toString());
            dangerZoneManager.displayDangerZones(this, naverMap, dangerZones);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "위험 구역 로드 실패", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadFacilities() {
        try {
            InputStream is = getAssets().open("facilities.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            
            JSONArray facilities = new JSONArray(sb.toString());
            facilityManager.displayFacilities(this, naverMap, facilities);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "시설 정보 로드 실패", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayCourse(int index) {
        // 기존 경로만 지우고 마커는 유지
        for (PathOverlay p : pathOverlays) p.setMap(null);
        pathOverlays.clear();

        try {
            JSONObject course = coursesJSON.getJSONObject(index);
            int color = getColorForIndex(index);

            // 마커는 표시하지 않고 경로만 표시
            JSONArray route = course.getJSONArray("route");
            for (int j = 0; j < route.length() - 1; j++) {
                JSONObject p1 = route.getJSONObject(j);
                JSONObject p2 = route.getJSONObject(j + 1);
                LatLng start = new LatLng(p1.getDouble("lat"), p1.getDouble("lng"));
                LatLng end = new LatLng(p2.getDouble("lat"), p2.getDouble("lng"));
                requestTMapWalkSegment(start, end, color);
            }
        } catch (Exception e) {
            Log.e("DisplayCourse", "코스 표시 실패", e);
        }
    }

    private void clearMap() {
<<<<<<< HEAD
        // 기존 마커들 제거 (메인 마커들 제외)
        List<Marker> markersToRemove = new ArrayList<>();
        for (Marker marker : activeMarkers) {
            String caption = marker.getCaptionText();
            // 메인 마커들(남한산성, 북한산)은 제거하지 않음
            if (!"남한산성 둘레길".equals(caption) && !"북한산 둘레길".equals(caption)) {
                markersToRemove.add(marker);
            }
        }
        
        // 코스 관련 마커들만 제거
        for (Marker marker : markersToRemove) {
            marker.setMap(null);
            activeMarkers.remove(marker);
        }
=======
        // 기존 마커들 제거
        for (Marker marker : activeMarkers) {
            marker.setMap(null);
        }
        activeMarkers.clear();
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb

        // 기존 경로들 제거
        for (PathOverlay overlay : pathOverlays) {
            overlay.setMap(null);
        }
        pathOverlays.clear();
        
        // 캐시 크기 관리 (100개 이상이면 절반 정리)
        if (routeCache.size() > 100) {
            clearOldCache();
        }
    }
    
    // 오래된 캐시 정리 (메모리 관리)
    private void clearOldCache() {
        Log.d("TMapAPI", "캐시 정리 시작 - 현재 캐시 수: " + routeCache.size());
        int targetSize = routeCache.size() / 2;
        List<String> keysToRemove = new ArrayList<>();
        
        int count = 0;
        for (String key : routeCache.keySet()) {
            if (count >= targetSize) break;
            keysToRemove.add(key);
            count++;
        }
        
        for (String key : keysToRemove) {
            routeCache.remove(key);
        }
        
        Log.d("TMapAPI", "캐시 정리 완료 - 정리 후 캐시 수: " + routeCache.size());
    }
    
    // 전체 캐시 지우기 (필요시 사용)
    private void clearAllCache() {
        routeCache.clear();
        Log.d("TMapAPI", "모든 캐시 삭제됨");
    }

    private int getColorForIndex(int i) {
        switch (i) {
            case 0: return 0xFFFF0000;
            case 1: return 0xFF0077FF;
            case 2: return 0xFF00AA00;
            default: return 0xFF888888;
        }
    }

    private void requestTMapWalkSegment(LatLng start, LatLng end, int color) {
        requestTMapWalkSegmentWithRetry(start, end, color, 0);
    }
    
    private void requestTMapWalkSegmentWithRetry(LatLng start, LatLng end, int color, int retryCount) {
        // 캐시 키 생성
        String cacheKey = String.format("%.6f,%.6f_%.6f,%.6f", 
            start.latitude, start.longitude, end.latitude, end.longitude);
        
        // 캐시에서 확인 (단, 직선 경로가 아닌 경우만)
        if (routeCache.containsKey(cacheKey)) {
            List<LatLng> cachedPath = routeCache.get(cacheKey);
            if (cachedPath != null && cachedPath.size() > 2) { // 2개 이상이면 실제 경로
                Log.d("TMapAPI", "캐시에서 실제 경로 로드: " + cacheKey + " (포인트: " + cachedPath.size() + ")");
                new Handler(Looper.getMainLooper()).post(() -> drawSegment(cachedPath, color));
                return;
            }
        }
        
        // 최대 재시도 횟수 초과 시 경로 표시하지 않음
        if (retryCount >= MAX_RETRY_COUNT) {
            Log.w("TMapAPI", "최대 재시도 횟수 초과 - 경로 표시 안함: " + cacheKey);
            new Handler(Looper.getMainLooper()).post(() -> 
                Toast.makeText(MapsActivity.this, "⚠️ 일부 경로를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
            );
            return;
        }
        
        // 동시 API 호출 수 확인
        int currentCalls = pendingApiCalls.get();
        if (currentCalls >= MAX_CONCURRENT_API_CALLS) {
            Log.w("TMapAPI", "API 호출 대기 중... 현재 대기: " + currentCalls + ", 재시도: " + retryCount);
            // 잠시 후 재시도
            new Handler(Looper.getMainLooper()).postDelayed(() -> 
                requestTMapWalkSegmentWithRetry(start, end, color, retryCount), API_DELAY_MS * 2);
            return;
        }
        
        // API 호출 수 증가
        pendingApiCalls.incrementAndGet();
        
        new Thread(() -> {
            try {
                // API 호출 간 딜레이 (재시도일 때는 더 길게)
                long delay = API_DELAY_MS + (retryCount * 300);
                Thread.sleep(delay);
                
                Log.d("TMapAPI", "경로 요청: " + cacheKey + " (재시도: " + retryCount + ", 대기중: " + pendingApiCalls.get() + ")");
                
                URL url = new URL("https://apis.openapi.sk.com/tmap/routes/pedestrian?version=1&format=json");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("appKey", TMAP_API_KEY);
                conn.setDoOutput(true);
                conn.setConnectTimeout(15000); // 15초 타임아웃
                conn.setReadTimeout(20000); // 20초 읽기 타임아웃

                JSONObject body = new JSONObject();
                body.put("startX", start.longitude);
                body.put("startY", start.latitude);
                body.put("endX", end.longitude);
                body.put("endY", end.latitude);
                body.put("reqCoordType", "WGS84GEO");
                body.put("resCoordType", "WGS84GEO");
                body.put("startName", "출발지");
                body.put("endName", "도착지");

                try (OutputStream os = conn.getOutputStream()) {
                    os.write(body.toString().getBytes("UTF-8"));
                }

                int code = conn.getResponseCode();
                InputStreamReader isr = new InputStreamReader(code == 200 ? conn.getInputStream() : conn.getErrorStream());
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) sb.append(line);

                if (code == 429) {
                    Log.w("TMapAPI", "API 할당량 초과 (재시도 " + retryCount + ") - " + delay + "ms 후 재시도");
                    // 429 오류 시 더 긴 딜레이 후 재시도
                    new Handler(Looper.getMainLooper()).postDelayed(() -> 
                        requestTMapWalkSegmentWithRetry(start, end, color, retryCount + 1), delay * 2);
                    return;
                } else if (code != 200) {
                    Log.e("TMapAPI", "HTTP 오류 " + code + " (재시도 " + retryCount + "): " + sb);
                    // 다른 HTTP 오류도 재시도
                    new Handler(Looper.getMainLooper()).postDelayed(() -> 
                        requestTMapWalkSegmentWithRetry(start, end, color, retryCount + 1), delay);
                    return;
                }

                JSONObject json = new JSONObject(sb.toString());
                JSONArray features = json.getJSONArray("features");

                List<LatLng> path = new ArrayList<>();
                for (int i = 0; i < features.length(); i++) {
                    JSONObject geometry = features.getJSONObject(i).getJSONObject("geometry");
                    if ("LineString".equals(geometry.getString("type"))) {
                        JSONArray coords = geometry.getJSONArray("coordinates");
                        for (int j = 0; j < coords.length(); j++) {
                            JSONArray point = coords.getJSONArray(j);
                            path.add(new LatLng(point.getDouble(1), point.getDouble(0)));
                        }
                    }
                }
                
                // 실제 경로만 표시 (3개 이상 포인트인 경우만)
                if (path.size() > 2) {
                    routeCache.put(cacheKey, new ArrayList<>(path));
                    Log.d("TMapAPI", "✅ 실제 경로 성공: " + cacheKey + " (포인트 수: " + path.size() + ", 재시도: " + retryCount + ")");
                    new Handler(Looper.getMainLooper()).post(() -> drawSegment(path, color));
                } else {
                    Log.w("TMapAPI", "유효하지 않은 경로 응답 (포인트: " + path.size() + ") - 재시도");
                    new Handler(Looper.getMainLooper()).postDelayed(() -> 
                        requestTMapWalkSegmentWithRetry(start, end, color, retryCount + 1), delay);
                }

            } catch (Exception e) {
                Log.e("TMapAPI", "경로 요청 실패 (재시도 " + retryCount + "): " + e.getMessage(), e);
                // 예외 발생 시에도 재시도
                new Handler(Looper.getMainLooper()).postDelayed(() -> 
                    requestTMapWalkSegmentWithRetry(start, end, color, retryCount + 1), API_DELAY_MS * (retryCount + 1));
            } finally {
                // API 호출 수 감소
                pendingApiCalls.decrementAndGet();
            }
        }).start();
    }

    private void drawSegment(List<LatLng> path, int color) {
        PathOverlay overlay = new PathOverlay();
        overlay.setCoords(path);
        overlay.setColor(color);
        overlay.setWidth(12);
        overlay.setMap(naverMap);
        pathOverlays.add(overlay);
        
        // 실제 경로 표시 완료 로그
        Log.d("TMapAPI", "✅ 실제 보행 경로 표시 완료 (포인트: " + path.size() + ")");
        
        // 첫 번째 경로가 표시될 때만 성공 토스트 (중복 방지)
        if (pathOverlays.size() == 1) {
            new Handler(Looper.getMainLooper()).post(() -> 
                Toast.makeText(MapsActivity.this, "✅ 실제 보행 경로가 표시되었습니다!", Toast.LENGTH_SHORT).show()
            );
        }
    }

    private void showMainMarkers() {
        try {
            clearMap();
            
            // 원형 버튼들과 정보 패널 완전히 숨기기
<<<<<<< HEAD
            courseInfoPanel.setVisibility(View.GONE);
            currentCourseIndex = -1; // 코스 인덱스 초기화
            
=======
            courseButtonsLayout.setVisibility(View.GONE);
            courseInfoPanel.setVisibility(View.GONE);
            currentCourseIndex = -1; // 코스 인덱스 초기화
            
            // 코스 선택 버튼 숨기기
            btnCourseSelector.setVisibility(View.GONE);
            
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
            // 남한산성 둘레길 마커 (산성로터리 위치)
            Marker namhansanMarker = new Marker();
            namhansanMarker.setPosition(new LatLng(37.478046, 127.184021));
            namhansanMarker.setCaptionText("남한산성 둘레길");
            namhansanMarker.setMap(naverMap);
            
            // 남한산성 마커 클릭 이벤트
            namhansanMarker.setOnClickListener(overlay -> {
                // 남한산성으로 부드럽게 이동하면서 확대
                CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                    new LatLng(37.478046, 127.184021), 14)
                    .animate(CameraAnimation.Easing, 1500);
                naverMap.moveCamera(cameraUpdate);
                
                // 코스 선택 버튼 보이기
<<<<<<< HEAD
                btnCloseInfo.setVisibility(View.VISIBLE);
                btnCloseInfo.setText("닫기");
                
                // 코스 선택 애니메이션
                courseInfoPanel.animate()
                    .translationY(PANEL_VISIBLE_Y)
                    .setDuration(500)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();
                
                // 남한산성 코스 정보 표시 (첫 번째 코스 정보로 표시)
                showNamhansanCourseInfo();
=======
                btnCourseSelector.setVisibility(View.VISIBLE);
                btnCourseSelector.setText("코스 선택"); // 초기 텍스트로 리셋
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
                
                // 코스 선택 안내 메시지
                Toast.makeText(MapsActivity.this, "우측 상단 버튼에서 원하는 코스를 선택하세요.", Toast.LENGTH_LONG).show();
                return true;
            });
            
            // 북한산 둘레길 마커 (북한산 위치)
            Marker bukhansanMarker = new Marker();
            bukhansanMarker.setPosition(new LatLng(37.6586, 126.9770));
            bukhansanMarker.setCaptionText("북한산 둘레길");
            bukhansanMarker.setMap(naverMap);
            
            // 북한산 마커 클릭 이벤트
            bukhansanMarker.setOnClickListener(overlay -> {
<<<<<<< HEAD
                // 북한산으로 부드럽게 이동하면서 확대
                CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
                    new LatLng(37.6586, 126.9770), 14)
                    .animate(CameraAnimation.Easing, 1500);
                naverMap.moveCamera(cameraUpdate);
                
                // 코스 선택 버튼 보이기
                btnCloseInfo.setVisibility(View.VISIBLE);
                btnCloseInfo.setText("닫기");
                
                // 코스 선택 애니메이션
                courseInfoPanel.animate()
                    .translationY(PANEL_VISIBLE_Y)
                    .setDuration(500)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();
                
                // 북한산 둘레길 정보 표시 (첫 번째 코스 정보로 표시)
                showBukhansanCourseInfo();
                
                // 코스 선택 안내 메시지
                Toast.makeText(MapsActivity.this, "우측 상단 버튼에서 원하는 코스를 선택하세요.", Toast.LENGTH_LONG).show();
=======
                Toast.makeText(MapsActivity.this, "북한산 둘레길 정보는 준비 중입니다.", Toast.LENGTH_SHORT).show();
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
                return true;
            });
            
            activeMarkers.add(namhansanMarker);
            activeMarkers.add(bukhansanMarker);
            
        } catch (Exception e) {
            Log.e("ShowMainMarkers", "메인 마커 표시 실패", e);
        }
    }

    private void displayAllCourses() {
        // 기존 경로만 지우고 마커는 유지
        for (PathOverlay p : pathOverlays) p.setMap(null);
        pathOverlays.clear();

<<<<<<< HEAD
        // 현재 선택된 지역에 따라 해당 지역의 코스만 표시
        if (currentCourseIndex >= 3) {
            // 북한산 코스 표시 (현재는 데이터가 없으므로 기본 마커만)
            clearMap();
            
            // 북한산 중심 마커 추가
            Marker centerMarker = new Marker();
            centerMarker.setPosition(new LatLng(37.6586, 126.9770));
            centerMarker.setCaptionText("북한산 정상");
            centerMarker.setIcon(OverlayImage.fromResource(R.drawable.marker_mountain));
            centerMarker.setWidth(60);
            centerMarker.setHeight(60);
            centerMarker.setMap(naverMap);
            activeMarkers.add(centerMarker);
            
            Toast.makeText(this, "📍 북한산 둘레길 마커를 표시합니다.\n⚠️ 북한산 코스 상세 경로는 준비 중입니다.", Toast.LENGTH_LONG).show();
        } else if (currentCourseIndex >= 0) {
            // 남한산성 코스 표시
            try {
                // 1코스, 2코스, 3코스 모두 표시
                for (int courseIndex = 0; courseIndex < coursesJSON.length(); courseIndex++) {
                    JSONObject course = coursesJSON.getJSONObject(courseIndex);
                    int color = getColorForIndex(courseIndex);

                    // 각 코스의 마커들 표시
                    JSONArray markers = course.getJSONArray("markers");
                    for (int j = 0; j < markers.length(); j++) {
                        JSONObject m = markers.getJSONObject(j);
                        Marker marker = new Marker();
                        marker.setPosition(new LatLng(m.getDouble("lat"), m.getDouble("lng")));
                        marker.setCaptionText(m.getString("name"));
                        marker.setMap(naverMap);
                        activeMarkers.add(marker);
                    }

                    // 각 코스의 경로 표시
                    JSONArray route = course.getJSONArray("route");
                    for (int j = 0; j < route.length() - 1; j++) {
                        JSONObject p1 = route.getJSONObject(j);
                        JSONObject p2 = route.getJSONObject(j + 1);
                        LatLng start = new LatLng(p1.getDouble("lat"), p1.getDouble("lng"));
                        LatLng end = new LatLng(p2.getDouble("lat"), p2.getDouble("lng"));
                        requestTMapWalkSegment(start, end, color);
                    }
                }
                
                Toast.makeText(this, "📍 남한산성 둘레길 모든 코스를 표시합니다.\n🔄 실제 보행 경로를 불러오는 중...", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Log.e("DisplayAllCourses", "남한산성 코스 표시 실패", e);
            }
        } else {
            // 메인 화면에서는 아무것도 표시하지 않음
            Toast.makeText(this, "먼저 남한산성 또는 북한산 마커를 클릭해주세요.", Toast.LENGTH_SHORT).show();
=======
        try {
            // 1코스, 2코스, 3코스 모두 표시
            for (int courseIndex = 0; courseIndex < coursesJSON.length(); courseIndex++) {
                JSONObject course = coursesJSON.getJSONObject(courseIndex);
                int color = getColorForIndex(courseIndex);

                // 각 코스의 마커들 표시
                JSONArray markers = course.getJSONArray("markers");
                for (int j = 0; j < markers.length(); j++) {
                    JSONObject m = markers.getJSONObject(j);
                    Marker marker = new Marker();
                    marker.setPosition(new LatLng(m.getDouble("lat"), m.getDouble("lng")));
                    marker.setCaptionText(m.getString("name"));
                    marker.setMap(naverMap);
                    activeMarkers.add(marker);
                }

                // 각 코스의 경로 표시
                JSONArray route = course.getJSONArray("route");
                for (int j = 0; j < route.length() - 1; j++) {
                    JSONObject p1 = route.getJSONObject(j);
                    JSONObject p2 = route.getJSONObject(j + 1);
                    LatLng start = new LatLng(p1.getDouble("lat"), p1.getDouble("lng"));
                    LatLng end = new LatLng(p2.getDouble("lat"), p2.getDouble("lng"));
                    requestTMapWalkSegment(start, end, color);
                }
            }
        } catch (Exception e) {
            Log.e("DisplayAllCourses", "전체 코스 표시 실패", e);
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
        }
    }

    private void displaySingleCourse(int courseIndex) {
        // 기존 모든 마커와 경로 지우기
        clearMap();

        try {
            JSONObject course = coursesJSON.getJSONObject(courseIndex);
            int color = getColorForIndex(courseIndex);
            String courseName = course.getString("name");

            // 선택된 코스의 마커들만 표시
            JSONArray markers = course.getJSONArray("markers");
            for (int j = 0; j < markers.length(); j++) {
                JSONObject m = markers.getJSONObject(j);
                Marker marker = new Marker();
                marker.setPosition(new LatLng(m.getDouble("lat"), m.getDouble("lng")));
                marker.setCaptionText(m.getString("name"));
                
                // 위치별 커스텀 마커 아이콘 설정
                String locationName = m.getString("name");
                int markerIcon = getMarkerIconForLocation(locationName);
                
                if (isPhotoMarker(locationName)) {
                    // 실제 사진인 경우 원형으로 변환해서 적용
                    OverlayImage circularImage = getCircularMarkerImageFromAssets(getPhotoFileName(locationName), color);
                    marker.setIcon(circularImage);
                    marker.setWidth(72);
                    marker.setHeight(72);
                } else {
                    // XML 마커인 경우 그대로 사용
                    marker.setIcon(OverlayImage.fromResource(markerIcon));
                    marker.setWidth(60);
                    marker.setHeight(60);
                }
                
                // 마커 클릭 이벤트 설정
                final String finalLocationName = locationName;
                marker.setOnClickListener(overlay -> {
                    MarkerInfo info = MarkerInfo.getMarkerInfo(finalLocationName);
                    showMarkerDetail(info.getName(), info.getDescription(), info.getImageUrl(), info.getType());
                    return true;
                });
                
                marker.setMap(naverMap);
                activeMarkers.add(marker);
            }

            // 선택된 코스의 경로 표시
            JSONArray route = course.getJSONArray("route");
            for (int j = 0; j < route.length() - 1; j++) {
                JSONObject p1 = route.getJSONObject(j);
                JSONObject p2 = route.getJSONObject(j + 1);
                LatLng start = new LatLng(p1.getDouble("lat"), p1.getDouble("lng"));
                LatLng end = new LatLng(p2.getDouble("lat"), p2.getDouble("lng"));
                requestTMapWalkSegment(start, end, color);
            }
            
            Log.d("DisplaySingleCourse", courseName + " 표시 완료");
        } catch (Exception e) {
            Log.e("DisplaySingleCourse", "단일 코스 표시 실패", e);
        }
    }

    // 위치별 마커 아이콘을 선택하는 메서드 - assets에서 로드
    private String getPhotoFileName(String locationName) {
        switch (locationName) {
            case "산성로터리":
                return "photo_sansungrotary.png";
            case "서문":
                return "photo_seomun.png";
            case "북문":
                return "photo_bukmun.png";
            case "남문":
                return "photo_nammun.png";
            case "동문":
                return "photo_dongmun.png";
            case "천주사터":
                return "photo_cheonjusateo.png";
            case "현절사":
                return "photo_hyeonjeolsa.png";
            case "장경사":
                return "photo_janggyeongsa.png";
            case "망월사":
                return "photo_mangwolsa.png";
            case "영월정":
                return "photo_yeongwoljeong.png";
            case "수어장대":
                return "photo_sueojangdae.png";
            case "남한산성세계유산센터":
                return "photo_heritage_center.png";
            case "국청사":
                return "photo_gukcheonsa.png";
            case "숭렬전":
                return "photo_sungryeoljeon.png";
            case "벌봉":
                return "photo_beolbong.png";
            default:
                return null;
        }
    }

    // assets에서 이미지를 로드하여 원형 마커 이미지 생성
    private OverlayImage getCircularMarkerImageFromAssets(String fileName, int borderColor) {
        try {
            InputStream inputStream = getAssets().open("images/" + fileName);
            Bitmap originalBitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            
            if (originalBitmap == null) {
                return OverlayImage.fromResource(R.drawable.marker_circle_red);
            }

            // 원형 비트맵 생성
            Bitmap circularBitmap = getCircularBitmap(originalBitmap);
            
            // 테두리 추가
            Bitmap finalBitmap = addBorderToCircularBitmap(circularBitmap, borderColor);
            
            return OverlayImage.fromBitmap(finalBitmap);
        } catch (Exception e) {
            Log.e("AssetLoader", "이미지 로드 실패: " + fileName, e);
            return OverlayImage.fromResource(R.drawable.marker_circle_red);
        }
    }

    // 위치별 마커 아이콘을 선택하는 메서드 - 백업용 XML 마커
    private int getMarkerIconForLocation(String locationName) {
        switch (locationName) {
            case "산성로터리":
                return R.drawable.marker_circle_red;
            case "서문":
            case "북문":
            case "남문":
            case "동문":
                return R.drawable.marker_gate;
            case "천주사터":
            case "현절사":
            case "장경사":
            case "망월사":
                return R.drawable.marker_temple;
            case "영월정":
            case "수어장대":
                return R.drawable.marker_pavilion;
            case "남한산성세계유산센터":
            case "국청사":
            case "숭렬전":
                return R.drawable.marker_center;
            case "벌봉":
                return R.drawable.marker_mountain;
            default:
                return R.drawable.marker_circle_red;
        }
    }

    // 실제 사진인지 확인하는 메서드 - 원형 처리 적용
    private boolean isPhotoMarker(String locationName) {
        switch (locationName) {
            case "산성로터리":
            case "서문":
            case "북문":
            case "남문":
            case "동문":
            case "천주사터":
            case "현절사":
            case "장경사":
            case "망월사":
            case "영월정":
            case "수어장대":
            case "남한산성세계유산센터":
            case "국청사":
            case "숭렬전":
            case "벌봉":
                return true;
            default:
                return false;
        }
    }

    // 비트맵을 원형으로 변환하는 메서드
    private Bitmap getCircularBitmap(Bitmap bitmap) {
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, size, size);
        RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xFFFFFFFF);
        
        // 원형 마스크 생성
        canvas.drawOval(rectF, paint);
        
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        
        // 원본 이미지를 정사각형으로 크롭
        int x = (bitmap.getWidth() - size) / 2;
        int y = (bitmap.getHeight() - size) / 2;
        Bitmap squareBitmap = Bitmap.createBitmap(bitmap, x, y, size, size);
        
        canvas.drawBitmap(squareBitmap, rect, rect, paint);

        return output;
    }

    // 원형 비트맵에 테두리 추가
    private Bitmap addBorderToCircularBitmap(Bitmap src, int borderColor) {
        int borderWidth = 6;
        int size = src.getWidth() + borderWidth * 2;
        
        Bitmap output = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        
        Paint borderPaint = new Paint();
        borderPaint.setColor(borderColor);
        borderPaint.setStyle(Paint.Style.FILL);
        borderPaint.setAntiAlias(true);
        
        // 테두리 원 그리기
        canvas.drawCircle(size / 2f, size / 2f, size / 2f, borderPaint);
        
        // 내부 흰색 원 그리기
        Paint whitePaint = new Paint();
        whitePaint.setColor(0xFFFFFFFF);
        whitePaint.setStyle(Paint.Style.FILL);
        whitePaint.setAntiAlias(true);
        canvas.drawCircle(size / 2f, size / 2f, (size - borderWidth * 2) / 2f, whitePaint);
        
        // 원형 이미지 그리기
        canvas.drawBitmap(src, borderWidth, borderWidth, null);
        
        return output;
    }

    // 코스 정보 표시
    private void showCourseInfo(int courseIndex) {
        if (courseIndex < 0 || courseIndex >= courseInfos.length) return;
        
        // 현재 코스 인덱스 저장
        currentCourseIndex = courseIndex;
        
        CourseInfo info = courseInfos[courseIndex];
        
        // 코스 정보 업데이트
        courseTitle.setText(info.title);
        courseTitle.setTextColor(info.titleColor);
        courseRecommendation.setText(info.recommendation);
        courseRecommendation.setTextColor(info.titleColor);
        courseDistance.setText(info.distance);
        courseDuration.setText(info.duration);
        courseDifficulty.setText(info.difficulty);
        courseDescription.setText(info.description);
        
        // 패널 보이기
        courseInfoPanel.setVisibility(View.VISIBLE);
        
        // 슬라이드 업 애니메이션
        courseInfoPanel.animate()
            .translationY(PANEL_VISIBLE_Y)
            .setDuration(500)
            .setInterpolator(new AccelerateDecelerateInterpolator())
            .start();
<<<<<<< HEAD
            
        // 전체보기 버튼 텍스트 업데이트
        updateAllCoursesButtonText();
    }

    // 전체보기 버튼 텍스트 업데이트
    private void updateAllCoursesButtonText() {
        Button btnAll = findViewById(R.id.btnAll);
        if (currentCourseIndex >= 3) {
            btnAll.setText("북한산 전체보기");
        } else if (currentCourseIndex >= 0) {
            btnAll.setText("남한산성 전체보기");
        } else {
            btnAll.setText("전체보기");
        }
    }

    // 남한산성 코스 정보 표시
    private void showNamhansanCourseInfo() {
        // 남한산성 첫 번째 코스 정보로 표시 (인덱스 0)
        currentCourseIndex = 0;
        
        CourseInfo info = courseInfos[0]; // 남한산성 1코스
        
        // 코스 정보 업데이트
        courseTitle.setText("남한산성 둘레길");
        courseTitle.setTextColor(info.titleColor);
        courseRecommendation.setText(info.recommendation);
        courseRecommendation.setTextColor(info.titleColor);
        courseDistance.setText(info.distance);
        courseDuration.setText(info.duration);
        courseDifficulty.setText(info.difficulty);
        courseDescription.setText(info.description);
        
        // 패널 보이기
        courseInfoPanel.setVisibility(View.VISIBLE);
        
        // 전체보기 버튼 텍스트 업데이트
        updateAllCoursesButtonText();
    }

    // 북한산 코스 정보 표시
    private void showBukhansanCourseInfo() {
        // 북한산 첫 번째 코스 정보로 표시 (인덱스 3)
        currentCourseIndex = 3;
        
        CourseInfo info = courseInfos[3]; // 북한산 1코스
        
        // 코스 정보 업데이트
        courseTitle.setText("북한산 둘레길");
        courseTitle.setTextColor(0xFF9C27B0); // 보라색
        courseRecommendation.setText("🏔️ 서울의 대표적인 산행지");
        courseRecommendation.setTextColor(0xFF9C27B0);
        courseDistance.setText("📏 총 거리: 13.5km (3개 코스)");
        courseDuration.setText("⏱️ 소요시간: 7시간30분 (전체)");
        courseDifficulty.setText("⭐⭐⭐ 난이도: 다양함");
        courseDescription.setText("서울의 대표적인 산행지인 북한산의 둘레길입니다. 도봉산, 우이동, 정릉 등 다양한 출발점에서 시작할 수 있으며, 각 코스마다 다른 난이도와 경관을 제공합니다. 서울의 아름다운 전경을 감상할 수 있는 최고의 산행지입니다.");
        
        // 패널 보이기
        courseInfoPanel.setVisibility(View.VISIBLE);
        
        // 전체보기 버튼 텍스트 업데이트
        updateAllCoursesButtonText();
=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
    }

    // 코스 정보 패널 숨기기
    private void hideCourseInfoPanel() {
        if (currentCourseIndex < 0 || currentCourseIndex >= PANEL_HIDDEN_Y_VALUES.length) {
            return; // 유효하지 않은 인덱스인 경우 아무것도 하지 않음
        }
        
        // 슬라이드 다운 애니메이션 (핸들은 보이도록)
        courseInfoPanel.animate()
            .translationY(PANEL_HIDDEN_Y_VALUES[currentCourseIndex])
            .setDuration(300)
            .setInterpolator(new AccelerateDecelerateInterpolator())
            .start();
        // visibility는 VISIBLE로 유지하여 드래그 가능하도록 함
    }

    // 패널 드래그 기능 설정
    private void setupPanelDrag() {
        courseInfoPanel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 유효한 코스가 선택되지 않은 경우 드래그 비활성화
                if (currentCourseIndex < 0 || currentCourseIndex >= PANEL_HIDDEN_Y_VALUES.length) {
                    return false;
                }
                
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 터치 시작
                        initialTouchY = event.getRawY();
                        initialPanelY = courseInfoPanel.getTranslationY();
                        isDragging = false;
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        // 드래그 중
                        if (!isDragging) {
                            float deltaY = Math.abs(event.getRawY() - initialTouchY);
                            if (deltaY > 10) { // 최소 드래그 감지 거리
                                isDragging = true;
                            }
                        }

                        if (isDragging) {
                            float currentY = event.getRawY();
                            float deltaY = currentY - initialTouchY;
                            float newTranslationY = initialPanelY + deltaY;

                            // 패널이 너무 위로 올라가거나 아래로 내려가지 않도록 제한
                            newTranslationY = Math.max(PANEL_VISIBLE_Y, newTranslationY);
                            newTranslationY = Math.min(PANEL_HIDDEN_Y_VALUES[currentCourseIndex], newTranslationY);

                            courseInfoPanel.setTranslationY(newTranslationY);
                        }
                        return true;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // 터치 종료
                        if (isDragging) {
                            handlePanelDragEnd();
                        } else {
                            // 단순 터치인 경우 아무것도 하지 않음 (버튼 클릭 등을 방해하지 않음)
                            return false;
                        }
                        isDragging = false;
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    // 드래그 종료 시 패널 위치 결정
    private void handlePanelDragEnd() {
        // 유효한 코스가 선택되지 않은 경우 처리하지 않음
        if (currentCourseIndex < 0 || currentCourseIndex >= PANEL_HIDDEN_Y_VALUES.length) {
            return;
        }
        
        float currentY = courseInfoPanel.getTranslationY();
        float targetY;
        long duration;

        // 현재 위치에 따라 완전히 보이거나 숨길지 결정
        if (currentY > DRAG_THRESHOLD) {
            // 임계값 이상 아래로 드래그한 경우 숨기기 (핸들만 보이도록)
            targetY = PANEL_HIDDEN_Y_VALUES[currentCourseIndex];
            duration = 250;
            courseInfoPanel.animate()
                .translationY(targetY)
                .setDuration(duration)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        } else {
            // 위쪽에서 놓은 경우 다시 완전히 보이기
            targetY = PANEL_VISIBLE_Y;
            duration = 200;
            courseInfoPanel.animate()
                .translationY(targetY)
                .setDuration(duration)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();
        }
    }

    @Override protected void onStart()   { super.onStart(); mapView.onStart(); }
    @Override protected void onResume()  { super.onResume(); mapView.onResume(); }
    @Override protected void onPause()   { super.onPause(); mapView.onPause(); }
    @Override protected void onStop()    { super.onStop(); mapView.onStop(); }
    @Override protected void onDestroy() { super.onDestroy(); mapView.onDestroy(); }
    @Override public void onLowMemory()  { super.onLowMemory(); mapView.onLowMemory(); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
<<<<<<< HEAD
        getMenuInflater().inflate(R.menu.menu_main, menu);
=======
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        this.optionsMenu = menu;
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
<<<<<<< HEAD
        int id = item.getItemId();
        if (id == R.id.action_drawer) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
=======
        if (item.getItemId() == R.id.action_settings) {
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
            drawerLayout.openDrawer(GravityCompat.END);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

<<<<<<< HEAD
    // 날씨 정보를 표시하는 메서드
    private void showWeatherInfo() {
        // 현재 위치의 날씨 정보를 가져와서 표시
        if (naverMap != null && locationSource != null) {
            Location location = locationSource.getLastLocation();
            if (location != null) {
                LatLng currentLocation = new LatLng(
                    location.getLatitude(),
                    location.getLongitude()
                );
                
                // 날씨 정보를 가져오는 API 호출
                new Thread(() -> {
                    try {
                        String weatherInfo = getWeatherInfo(currentLocation);
                        runOnUiThread(() -> {
                            // 날씨 정보를 다이얼로그로 표시
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle("현재 날씨")
                                   .setMessage(weatherInfo)
                                   .setPositiveButton("확인", null)
                                   .show();
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        runOnUiThread(() -> {
                            Toast.makeText(this, "날씨 정보를 가져오는데 실패했습니다.", Toast.LENGTH_SHORT).show();
                        });
                    }
                }).start();
            } else {
                Toast.makeText(this, "위치 정보를 가져올 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // 날씨 정보를 가져오는 메서드
    private String getWeatherInfo(LatLng location) throws Exception {
        // OpenWeatherMap API를 사용하여 날씨 정보 가져오기
        String apiKey = "7a4aa78797771aa887fe9b14a9be94e5"; // OpenWeatherMap API 키
        String url = String.format(
            "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s&units=metric&lang=kr",
            location.latitude, location.longitude, apiKey
        );

        URL weatherUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) weatherUrl.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // JSON 파싱
        JSONObject json = new JSONObject(response.toString());
        JSONObject main = json.getJSONObject("main");
        JSONArray weather = json.getJSONArray("weather");
        JSONObject weatherInfo = weather.getJSONObject(0);

        double temp = main.getDouble("temp");
        String description = weatherInfo.getString("description");
        int humidity = main.getInt("humidity");

        return String.format(
            "현재 날씨: %s\n기온: %.1f°C\n습도: %d%%",
            description, temp, humidity
        );
=======
    // 코스 선택 팝업 메뉴 표시
    private void showCoursePopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnCourseSelector);
        popupMenu.getMenuInflater().inflate(R.menu.course_popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.popup_course1) {
                selectCourse(0);
                btnCourseSelector.setText("코스1");
                return true;
            } else if (itemId == R.id.popup_course2) {
                selectCourse(1);
                btnCourseSelector.setText("코스2");
                return true;
            } else if (itemId == R.id.popup_course3) {
                selectCourse(2);
                btnCourseSelector.setText("코스3");
                return true;
            }
            return false;
        });

        popupMenu.show();
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
    }

    // 코스 선택 처리
    private void selectCourse(int courseIndex) {
        // 남한산성으로 부드럽게 이동
        CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
            new LatLng(37.478046, 127.184021), 14)
            .animate(CameraAnimation.Easing, 1500);
        naverMap.moveCamera(cameraUpdate);
        
        // 선택된 코스만 표시
        displaySingleCourse(courseIndex);
        
        // 코스 정보 표시
        showCourseInfo(courseIndex);
        
        String courseName = courseInfos[courseIndex].title;
        Toast.makeText(this, "📍 " + courseName + " 마커와 경로를 표시합니다.\n🔄 실제 보행 경로를 불러오는 중...", Toast.LENGTH_LONG).show();
    }

<<<<<<< HEAD
    // 북한산 코스 선택 처리
    private void selectBukhansanCourse(int courseIndex) {
        // 북한산으로 부드럽게 이동
        CameraUpdate cameraUpdate = CameraUpdate.scrollAndZoomTo(
            new LatLng(37.6586, 126.9770), 14)
            .animate(CameraAnimation.Easing, 1500);
        naverMap.moveCamera(cameraUpdate);
        
        // 현재는 북한산 코스 데이터가 없으므로 기본 마커만 표시
        clearMap();
        
        // 북한산 중심 마커 추가
        Marker centerMarker = new Marker();
        centerMarker.setPosition(new LatLng(37.6586, 126.9770));
        centerMarker.setCaptionText("북한산 정상");
        centerMarker.setIcon(OverlayImage.fromResource(R.drawable.marker_mountain));
        centerMarker.setWidth(60);
        centerMarker.setHeight(60);
        centerMarker.setMap(naverMap);
        activeMarkers.add(centerMarker);
        
        // 코스 정보 표시
        showCourseInfo(courseIndex);
        
        String courseName = courseInfos[courseIndex].title;
        Toast.makeText(this, "📍 " + courseName + " 정보를 표시합니다.\n⚠️ 북한산 코스 상세 경로는 준비 중입니다.", Toast.LENGTH_LONG).show();
        
        // 전체보기 버튼 텍스트 업데이트
        updateAllCoursesButtonText();
    }

    // 남한산성 코스 메뉴 표시
    private void showNamhansanCourseMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.course_popup_menu, popupMenu.getMenu());
        
        // 북한산 코스 메뉴 아이템들 제거
        popupMenu.getMenu().removeItem(R.id.popup_course4);
        popupMenu.getMenu().removeItem(R.id.popup_course5);
        popupMenu.getMenu().removeItem(R.id.popup_course6);

        popupMenu.setOnMenuItemClickListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.popup_course1) {
                selectCourse(0);
                return true;
            } else if (itemId == R.id.popup_course2) {
                selectCourse(1);
                return true;
            } else if (itemId == R.id.popup_course3) {
                selectCourse(2);
                return true;
            }
            return false;
        });

        popupMenu.show();
    }

    // 북한산 코스 메뉴 표시
    private void showBukhansanCourseMenu(View anchorView) {
        PopupMenu popupMenu = new PopupMenu(this, anchorView);
        popupMenu.getMenuInflater().inflate(R.menu.course_popup_menu, popupMenu.getMenu());
        
        // 남한산성 코스 메뉴 아이템들 제거
        popupMenu.getMenu().removeItem(R.id.popup_course1);
        popupMenu.getMenu().removeItem(R.id.popup_course2);
        popupMenu.getMenu().removeItem(R.id.popup_course3);

        popupMenu.setOnMenuItemClickListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.popup_course4) {
                selectBukhansanCourse(3);
                return true;
            } else if (itemId == R.id.popup_course5) {
                selectBukhansanCourse(4);
                return true;
            } else if (itemId == R.id.popup_course6) {
                selectBukhansanCourse(5);
                return true;
            }
            return false;
        });

        popupMenu.show();
    }

=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
    // 위치 업데이트 시 위험 구역 체크
    private void checkDangerZone(LatLng location) {
        if (dangerZoneManager != null) {
            dangerZoneManager.checkUserInDangerZone(this, location);
        }
    }

    // 마커 클릭 시 상세 정보 표시
    private void showMarkerDetail(String title, String description, String imageUrl, String type) {
        MarkerDetailFragment fragment = MarkerDetailFragment.newInstance(title, description, imageUrl, type);
        fragment.show(getSupportFragmentManager(), "marker_detail");
    }
<<<<<<< HEAD

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 권한이 승인된 경우
                if (locationSource != null) {
                    locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults);
                }
                // 위치 추적 모드 설정
                if (naverMap != null) {
                    naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
                }
            } else {
                // 권한이 거부된 경우
                Toast.makeText(this, "위치 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setupLocationSource() {
        if (naverMap != null) {
            locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);
            naverMap.setLocationSource(locationSource);
            naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
        }
    }

    private void moveToCurrentLocation() {
        if (naverMap != null && locationSource != null) {
            Location location = locationSource.getLastLocation();
            if (location != null) {
                LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                naverMap.moveCamera(CameraUpdate.scrollTo(currentLocation));
            }
        }
    }
=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
}












