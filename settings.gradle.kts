pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs")
    }
}

val buildCacheDirPath = System.getenv("BUILD_CACHE_DIR") ?: System.getProperty("user.home") + "/.photo-galaxy-build-cache"

buildCache {
    println("Using build cache directory: $buildCacheDirPath")
    local {
        directory = File(buildCacheDirPath)
        removeUnusedEntriesAfterDays = 30
    }
}

rootProject.name = "Photo Galaxy"
include(":app")
