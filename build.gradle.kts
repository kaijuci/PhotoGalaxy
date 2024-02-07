buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
        classpath("com.google.dagger:hilt-android-gradle-plugin:" + libs.findVersion("hilt").get())
        classpath("com.android.tools.build:gradle:" + libs.findVersion("gradle").get())
    }
}

plugins {
    alias(libs.plugins.android.cache.fix) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
}

subprojects {
    plugins.withType<com.android.build.gradle.api.AndroidBasePlugin>() {
        apply(plugin = "org.gradle.android.cache-fix")
    }
}
