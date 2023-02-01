package com.matheussilas97.data.service

import com.matheussilas97.data.model.response.AddressResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {

    @GET("{cep}/json/")
    fun searchPostalCode(@Path("cep") postalCode: String): AddressResponse?

}