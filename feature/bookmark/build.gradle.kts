plugins {
    id("devkick.feature")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.devkick.detail"
}

dependencies {
    implementation(projects.core.navigation)
}