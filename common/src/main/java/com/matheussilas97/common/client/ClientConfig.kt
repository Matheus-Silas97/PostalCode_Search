package com.matheussilas97.common.client

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ClientConfig {
    fun create(): HttpClient {
        return HttpClient(OkHttp) {
            install(Resources)
            expectSuccess = true
            install(ContentNegotiation) {
                json(
                    json = Json {
                        encodeDefaults = true
                        isLenient = true
                        allowSpecialFloatingPointValues = true
                        allowStructuredMapKeys = true
                        prettyPrint = false
                        useArrayPolymorphism = false
                        ignoreUnknownKeys = true
                    }
                )
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                url(urlString = "https://viacep.com.br/")
            }
        }
    }
}