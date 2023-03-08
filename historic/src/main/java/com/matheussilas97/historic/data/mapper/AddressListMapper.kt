package com.matheussilas97.historic.data.mapper

import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.local.entity.AddressEntity

fun List<AddressEntity>.toAddressList(): List<Address> = this.map {
    Address(
        id = it.id,
        postalCode = it.postalCode,
        street = it.street,
        complement = it.complement,
        neighborhood = it.neighborhood,
        city = it.city,
        state = it.state
    )
}