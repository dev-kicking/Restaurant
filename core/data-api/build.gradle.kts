plugins {
    id("devkick.module")
}

android {
    namespace = "com.devkick.data_api"
}

dependencies {
    implementation(projects.core.model)
}