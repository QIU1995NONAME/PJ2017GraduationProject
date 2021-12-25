buildscript {
    repositories {
        mavenCentral()
    }
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-serialization")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
//    }
}

allprojects {
    buildscript {
        repositories {
            mavenCentral();
        }
    }
    repositories {
        mavenCentral();
    }
}

plugins {
    `java-library`
    kotlin("jvm") version Versions.Kotlin.lang apply false
    kotlin("kapt") version Versions.Kotlin.lang apply false
    kotlin("plugin.serialization") version Versions.Kotlin.lang apply false
}

//ext {
//    _java = [
//        _version: JavaVersion.VERSION_1_8,
//    ];
//};
