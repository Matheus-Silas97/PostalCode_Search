package com.matheussilas97.search.data.service

import com.matheussilas97.search.data.response.AddressResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {

    @GET(SEARCH_CEP_URL)
    suspend fun searchPostalCode(@Path(POSTAL_CODE) postalCode: String): AddressResponse?

    companion object {
        const val SEARCH_CEP_URL = "{cep}/json/"
        const val POSTAL_CODE = "cep"
    }
}