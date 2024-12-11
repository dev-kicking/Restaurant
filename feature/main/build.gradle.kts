plugins {
    id("devkick.feature")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.devkick.main"
}

dependencies {
    implementation(projects.core.navigation)
    implementation(projects.feature.home)
    implementation(projects.feature.bookmark)
}