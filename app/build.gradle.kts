

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id("kotlin-kapt")    //Añadimos como plugin el compilador que usa Room Database

}

android {
    namespace = "com.universae.memy"
    compileSdk = 34

    buildFeatures {
        dataBinding = true //Añadimos el soporte para usar dataBinding para la unión de los ViewModels con los fragmentos
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
   implementation(libs.androidx.preference) //Añadimos la librería Preference para su uso con los ajustes


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /*Añadimos las librerías de Navigation para poder implementar la navegación entre componentes
     y usamos la variable con la versión de librería para poder cambiarlo fácilmente de ser necesario */
    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    /*Añadimos las librerías de Room y Lifecycle para poder implementar la base de datos y las demás partes
    * del diseño MVVM */
    val room_version = "2.6.1"
    val lifecycle_version = "2.7.0"

    annotationProcessor("androidx.room:room-compiler:$room_version")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    /*Añadimos la librería de RecyclerView para definir cómo mostrar todos los objetos de
    la base de datos con adaptadores */
    val recycler_version = "1.3.2"
    implementation("androidx.recyclerview:recyclerview:$recycler_version")

    /*Añadimos la librería de Preference para su uso con el fragmento de ajustes */
    val preference_version = "1.2.0"
    implementation("androidx.preference:preference-ktx:1.2.0")
}