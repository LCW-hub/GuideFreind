plugins {
    alias(libs.plugins.android.application)
<<<<<<< HEAD
    id("com.google.gms.google-services")
=======
<<<<<<< HEAD
    id("com.google.gms.google-services")
=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
}

android {
    namespace = "com.example.gps"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.gps"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // 리소스 최적화 설정
    androidResources {
        noCompress += listOf("png", "jpg", "jpeg")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd

    configurations {
        all {
            exclude(group = "androidx.annotation", module = "annotation-experimental")
        }
    }
<<<<<<< HEAD
=======
=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.naver.maps:map-sdk:3.21.0")
    implementation ("com.google.android.gms:play-services-location:21.0.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
<<<<<<< HEAD
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
=======
<<<<<<< HEAD
    
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-messaging")
    
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
=======
>>>>>>> eb6a61de94925d9caf84c525f5335968ab81c5fb
>>>>>>> 79f409103bc7353cce929cad1eee9d655a3c06bd
}