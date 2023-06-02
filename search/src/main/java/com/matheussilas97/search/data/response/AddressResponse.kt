package com.matheussilas97.search.data.response

import com.google.gson.annotations.SerializedName
import io.ktor.resources.Resource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class AddressResponse(

    @SerialName("cep")
    val postalCode: String,

    @SerialName("logradouro")
    val street: String,

    @SerialName("complemento")
    val complement: String,

    @SerialName("bairro")
    val neighborhood: String,

    @SerialName("localidade")
    val city: String,

    @SerialName("uf")
    val state: String

)