pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "PostalCode Search"

rootDir
    .walk()
    .maxDepth(depth = 1)
    .filter { folder ->
        folder.name != "buildSrc"
                && folder.isDirectory
                && folder.name != rootDir.name
                && (folder.fileExists("build.gradle.kts") || folder.fileExists("build.gradle"))
    }
    .forEach { file ->
        val name = ":${file.name}"
        include(name)
    }

fun File.fileExists(file: String) = file(path = "${this.absolutePath}/$file").exists()