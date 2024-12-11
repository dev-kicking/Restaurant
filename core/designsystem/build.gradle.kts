plugins {
    id("devkick.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.devkick.designsystem"
}

dependencies {
    implementation(projects.resource)
}