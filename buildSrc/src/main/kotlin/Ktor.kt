import org.gradle.api.artifacts.dsl.DependencyHandler

object Ktor {
    private const val version = "2.1.2"

    const val core = "io.ktor:ktor-client-core:$version"
    const val okhttp = "io.ktor:ktor-client-okhttp:$version"
    const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
    const val logging = "io.ktor:ktor-client-logging:$version"
    const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
    const val resource = "io.ktor:ktor-client-resources:$version"
    const val auth = "io.ktor:ktor-client-auth:$version"

    fun implementDependencies(dependency: DependencyHandler) = dependency.apply {
        apiDependency(dependency = core)
        apiDependency(dependency = okhttp)
        apiDependency(dependency = serialization)
        apiDependency(dependency = logging)
        apiDependency(dependency = contentNegotiation)
        apiDependency(dependency = resource)
        apiDependency(dependency = auth)
    }
}