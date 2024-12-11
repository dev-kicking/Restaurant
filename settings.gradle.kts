enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        gradlePluginPortal()
    }
}

rootProject.name = "restaurant"
include(":app")

// Core
include(
    ":core:data",
    ":core:data-api",
    ":core:domain",
    ":core:designsystem",
    ":core:model",
    ":core:navigation"
)

// Feature
include(
    ":feature:bookmark",
    ":feature:main",
    ":feature:home"
)

// Resource
include(":resource")
