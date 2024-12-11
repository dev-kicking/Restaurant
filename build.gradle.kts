plugins {
    alias(libs.plugins.gradleWrapperUpgrade) apply false
    alias(libs.plugins.koverPlugin) apply false
    alias(libs.plugins.compose.compiler) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.hilt.gradle.plugin)
        classpath(libs.kotlinx.serialization.plugin)
        classpath(libs.ksp.plugin)
    }
}