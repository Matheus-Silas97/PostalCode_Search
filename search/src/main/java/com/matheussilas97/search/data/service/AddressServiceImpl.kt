package com.matheussilas97.search.data.service

import com.matheussilas97.search.data.response.AddressResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AddressServiceImpl(
    private val client: HttpClient
): AddressService {
    override suspend fun searchPostalCode(postalCode: String): AddressResponse? {
        return client.get("ws/{code}/json/").body()
    }
}

