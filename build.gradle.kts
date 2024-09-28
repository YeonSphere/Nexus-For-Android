// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

// Enable Gradle's version catalog feature
enableFeaturePreview("VERSION_CATALOGS")

// Common configurations for all projects
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Task to clean the build directory
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}