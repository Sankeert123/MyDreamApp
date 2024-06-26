// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false

    // Adding the dependency for the Google services Gradle plugin
    id("com.google.gms.google-services") version "4.4.2" apply false

}