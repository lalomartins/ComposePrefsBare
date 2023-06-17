plugins {
    kotlin("multiplatform") version "1.8.20"
    id("org.jetbrains.compose") version "1.4.0"
    id("com.android.library") version "7.4.2"
}

group = "info.lalomartins"
version = "1.0.4+1"

repositories {
    google()
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(17)
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    // no skiko-js (yet?)
//    js {
//        browser {
//            commonWebpackConfig {
//                cssSupport {
//                    enabled.set(true)
//                }
//            }
//        }
//    }
    android {
        jvmToolchain(17)
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.ui)
                api(compose.material3)
                api("androidx.compose.material3:material3-window-size-class:1.1.0")
                api("androidx.appcompat:appcompat:1.6.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
//        val jvmTest by getting
//        val jsMain by getting
//        val jsTest by getting
        val androidMain by getting
//        val androidTest by getting {
//            dependencies {
//                implementation("junit:junit:4.13.2")
//            }
//        }
    }
}

android {
    namespace = "info.lalomartins.composeprefs3"
    compileSdk = 32
    defaultConfig {
        minSdk = 24
        targetSdk = 32
        version = "1.0.4+1"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

// Android
android.compileOptions.targetCompatibility = JavaVersion.VERSION_17

// Java/Kotlin
java.targetCompatibility = JavaVersion.VERSION_17
