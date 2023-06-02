plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.matheussilas97.common"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Kotlin.jvmVersion
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Kotlin.compilerExtensionVersion
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    Android.implementDependencies(dependency = this)

    api(dependencyNotation = "androidx.compose.material3:material3:1.0.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val roomVersion = "2.4.3"
    api(dependencyNotation = "androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    api(dependencyNotation = "com.squareup.retrofit2:retrofit:2.9.0")
    api(dependencyNotation = "com.squareup.retrofit2:converter-gson:2.9.0")
    api(dependencyNotation = "com.google.code.gson:gson:2.10.1")
    val composeUiVersion = "1.1.1"

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeUiVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeUiVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeUiVersion")

    val navVersion = "2.5.3"
    api(dependencyNotation = "androidx.navigation:navigation-compose:$navVersion")
    api(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    api(dependencyNotation = "io.insert-koin:koin-androidx-compose:3.4.1")
    api(dependencyNotation = Ktor.core)
    api(dependencyNotation = Ktor.okhttp)
    api(dependencyNotation = Ktor.serialization)
    api(dependencyNotation = Ktor.logging)
    api(dependencyNotation = Ktor.contentNegotiation)
    api(dependencyNotation = Ktor.resource)
    api(dependencyNotation = Ktor.auth)
}