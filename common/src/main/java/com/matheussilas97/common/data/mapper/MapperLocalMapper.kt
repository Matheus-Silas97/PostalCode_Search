package com.matheussilas97.common.data.mapper

import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.local.entity.AddressEntity

fun Address.toAddressObject(): AddressEntity = AddressEntity(
    id = this.id,
    postalCode = this.postalCode ?: "",
    street = this.street ?: "",
    complement = this.complement ?: "",
    neighborhood = this.neighborhood ?: "",
    city = this.city ?: "",
    state = this.state ?: ""
)