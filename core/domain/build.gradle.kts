plugins {
    id("devkick.module")
}

android {
    namespace = "com.devkick.domain.image"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.dataApi)
    implementation(projects.core.model)
}