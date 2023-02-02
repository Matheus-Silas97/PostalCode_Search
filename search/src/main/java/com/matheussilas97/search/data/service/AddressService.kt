package com.matheussilas97.search.data.service

import com.matheussilas97.search.data.response.AddressResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {

    @GET("{cep}/json/")
    fun searchPostalCode(@Path("cep") postalCode: String): AddressResponse?

}