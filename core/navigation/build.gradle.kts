plugins {
    id("devkick.module")
}

android {
    namespace = "com.devkick.navigation"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}