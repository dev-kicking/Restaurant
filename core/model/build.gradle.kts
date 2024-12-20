plugins {
    id("devkick.module")
}

android {
    namespace = "com.devkick.model"
}

dependencies {
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
}