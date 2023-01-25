package com.matheussilas97.data.model.response

import com.google.gson.annotations.SerializedName

data class AddressResponse(

    @SerializedName("cep")
    val postalCode: String,

    @SerializedName("logradouro")
    val street: String,

    @SerializedName("complemento")
    val complement: String,

    @SerializedName("bairro")
    val neighborhood: String,

    @SerializedName("localidade")
    val city: String,

    @SerializedName("uf")
    val state: String

)