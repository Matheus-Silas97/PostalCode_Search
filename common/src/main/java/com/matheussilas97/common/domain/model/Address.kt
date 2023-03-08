package com.matheussilas97.common.domain.model

data class Address(

    val id: Long = 0L,

    val postalCode: String? = "",

    val street: String? = "",

    val complement: String? = "",

    val neighborhood: String? = "",

    val city: String? = "",

    val state: String? = ""

)
