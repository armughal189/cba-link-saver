plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.koin.compiler)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.kotlinx.serialization)
  alias(libs.plugins.ksp)
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
    versionCode = 1
    versionName = "1.0.0"
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
  lint {
    disable += mutableSetOf("Instantiatable")
  }
}

dependencies {
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.graphics)
  implementation(libs.androidx.compose.material.icons.core)
  implementation(libs.androidx.compose.material.icons.extended)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.material3.adaptive.navigation.suite)
  implementation(libs.androidx.navigation3.runtime)
  implementation(libs.androidx.navigation3.ui)
  implementation(libs.androidx.preference.ktx)
  implementation(libs.androidx.room3.runtime)
  implementation(platform(libs.koin.bom))
  implementation(libs.koin.android)
  implementation(libs.koin.annotations)
  implementation(libs.koin.compose)
  implementation(libs.koin.compose.viewmodel)
  implementation(libs.material)
  ksp(libs.androidx.room3.compiler)
}