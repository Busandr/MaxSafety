plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.busandr.maxsafety"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.busandr.maxsafety"
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
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
//    implementation(libs.patternlockview)
//    implementation(libs.patternlockview)
//    implementation(libs.com.andrognito.patternlockview.patternlockview)
//    implementation("com.andrognito.patternlockview:patternlockview:2.2.0")
//    implementation ("me.zhanghai.android.patternlock:library:2.1.2")
//    compile 'com.andrognito.patternlockview:patternlockview:2.2.0'

    implementation(libs.androidx.biometric)
//    implementation(libs.androidxbiometric:biometric:1.1.0)
//    implementation()
//    implementation(android)//.core:core:1.7.0)

}