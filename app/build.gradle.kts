plugins {
  id("com.android.application")
  id("com.google.devtools.ksp")
  id("io.insert-koin.compiler.plugin")
  id("org.jetbrains.kotlin.plugin.compose")
  id("org.jetbrains.kotlin.plugin.serialization")
}

android {
  namespace = "io.multidev134.link_saver"
  compileSdk {
    version = release(37)
  }

  defaultConfig {
    applicationId = "io.multidev134.link_saver"
    minSdk = 28
    targetSdk = 37
    versionCode = 15
    versionName = "2.0.0"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  buildFeatures {
    compose = true
  }
}

dependencies {
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.core:core-ktx:1.19.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.11.0")
  implementation("androidx.activity:activity-compose:1.13.0")
  implementation("com.google.android.material:material:1.14.0")
  implementation(platform("androidx.compose:compose-bom:2026.06.01"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.material:material-icons-core")
  implementation("androidx.compose.material:material-icons-extended")
  implementation("androidx.compose.material3:material3")
  implementation("androidx.compose.material3:material3-adaptive-navigation-suite")
  implementation("androidx.navigation3:navigation3-runtime:1.1.4")
  implementation("androidx.navigation3:navigation3-ui:1.1.4")
  implementation("androidx.room3:room3-runtime:3.0.0")
  ksp("androidx.room3:room3-compiler:3.0.0")

  implementation(platform("io.insert-koin:koin-bom:4.2.2"))
  implementation("io.insert-koin:koin-android")
  implementation("io.insert-koin:koin-annotations")
  implementation("io.insert-koin:koin-compose")
  implementation("io.insert-koin:koin-compose-viewmodel")

  implementation(platform("io.github.jan-tennert.supabase:bom:3.6.0"))
  implementation("io.github.jan-tennert.supabase:postgrest-kt")
  implementation("io.github.jan-tennert.supabase:auth-kt")
  implementation("io.ktor:ktor-client-android:3.5.1")
  implementation("com.russhwolf:multiplatform-settings-no-arg:1.3.0")
  implementation("com.aventrix.jnanoid:jnanoid:2.0.0")
}