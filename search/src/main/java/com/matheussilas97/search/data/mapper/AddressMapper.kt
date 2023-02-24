package com.matheussilas97.search.data.mapper

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.search.data.response.AddressResponse

fun AddressResponse?.toAddressEntity(): AddressEntity =
    AddressEntity(
        postalCode = this?.postalCode ?: "",
        street = this?.street ?: "",
        complement = this?.complement ?: "",
        neighborhood = this?.neighborhood ?: "",
        city = this?.city ?: "",
        state = this?.state ?: ""
    )
