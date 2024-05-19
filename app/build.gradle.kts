plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    //Añadimos el plugin Safe Args para poder pasar datos entre fragmentos del framework Navigation
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")

}

android {
    namespace = "com.universae.memy"
    compileSdk = 34

    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.universae.memy"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "1.8"
    }


}

dependencies {
   //Añadimos la versión del framework de Navigation dentro de una variable
    val nav_version = "2.7.7"


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Añadimos las dependencias usadas para implementar el framework de Navigation
    // y usamos la variable con la versión del framework
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    val room_version = "2.6.1"
    val lifecycle_version = "2.7.0"

    annotationProcessor("androidx.room:room-compiler:$room_version")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    kapt("androidx.room:room-compiler:$room_version")


}