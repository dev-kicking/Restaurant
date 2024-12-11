import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("devkick.module")
}

android {
    namespace = "com.devkick.data"
    
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        val properties = gradleLocalProperties(rootDir, providers)
        buildConfigField("String", "CLIENT_ID", "\"${properties.getProperty("CLIENT_ID")}\"")
        buildConfigField("String", "CLIENT_SECRET", "\"${properties.getProperty("CLIENT_SECRET")}\"")
    }
}

dependencies {
    implementation(libs.bundles.retrofit)
    implementation(projects.core.model)
    implementation(projects.core.dataApi)
    implementation(libs.kotlinx.serialization.json)
}