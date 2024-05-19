// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

}

//Añadimos los repositorios de Google para uso del build script
buildscript {
    repositories {
        google()
    }
    //Cómo Safe Args forma parte de una librería externa la añadimos a la variable de entorno
    // para su uso en todo el proyecto
    dependencies {
        val nav_version = "2.7.7"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")



    }
}