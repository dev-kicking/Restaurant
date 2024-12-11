plugins {
    id("devkick.compose")
}

dependencies {
    implementation(project(":resource"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(project(":core:domain"))
}