plugins {
    id("devkick.module")
}

android {
    // Compose
    buildFeatures {
        compose = true
    }

    lint {
        disable += "MissingTranslation"
        disable += "ComposeViewModelInjection"
        abortOnError = false
    }
}

dependencies {
    implementation(libs.bundles.compose)
    implementation(libs.bundles.coil)
}