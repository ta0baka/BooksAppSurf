plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Hilt
    alias(libs.plugins.hiltAndroid)
    id("org.jetbrains.kotlin.kapt")
}

hilt {
    enableAggregatingTask = false
}

android {
    namespace = "com.example.booksapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.booksapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.appcompat)

    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Hilt for dependency injection
    implementation(libs.hilt)
    implementation(libs.hiltNavigationCompose)
    kapt(libs.hiltCompiler)

    // Retrofit for network calls
    implementation(libs.retrofit2)
    implementation(libs.retrofit2GsonConverter)

    // OkHttp for HTTP requests and logging
    implementation(libs.okhttp3)
    implementation(libs.okhttp3Logging)

    // Coroutines for asynchronous programming
    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)

    // Coroutine Lifecycle Scopes for view model integration
    implementation(libs.lifecycleViewModel)

    // Navigation for composable screens
    implementation(libs.navigationCompose)

    // Coil for image loading
    implementation(libs.coil.compose)
}

kapt {
    correctErrorTypes = true
}