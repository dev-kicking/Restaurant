plugins {
    id("com.google.devtools.ksp")
    id("com.android.application")
    id("kotlin-android")

    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")

    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.devkick.restaurant"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "com.devkick.restaurant"
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.compile.sdk.get().toInt()
        versionName = libs.versions.version.name.get()
        versionCode = libs.versions.version.code.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.activity)

    implementation(libs.bundles.hilt)
    implementation(libs.material)
    kapt(libs.hilt.compiler)

    implementation(libs.timber)

    implementation(projects.core.designsystem)
    implementation(projects.resource)
    implementation(projects.feature.main)
}