import org.gradle.api.artifacts.dsl.DependencyHandler

object Android {
    const val versionApplication = "7.4.2"
    private const val versionCore = "1.7.0"
    private const val versionLifecycle = "2.3.1"

    const val dependencyLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$versionLifecycle"
    const val dependencyCore = "androidx.core:core-ktx:$versionCore"

    const val idApplication = "com.android.application"
    const val idLibrary = "com.android.library"

    fun implementDependencies(dependency: DependencyHandler) = dependency.apply {
        implementation(dependencyNotation = dependencyLifecycle)
        implementation(dependencyNotation = dependencyCore)
    }
}