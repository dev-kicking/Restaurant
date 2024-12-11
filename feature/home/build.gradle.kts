plugins {
    id("devkick.feature")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.devkick.home"
}

dependencies {
    implementation(projects.core.navigation)
}