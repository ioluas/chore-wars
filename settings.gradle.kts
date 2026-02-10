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
}

rootProject.name = "Eddar"
include(":app")
include(":core")
include(":data")
include(":domain")
include(":feature:auth")
include(":feature:chores")
include(":feature:teams")
