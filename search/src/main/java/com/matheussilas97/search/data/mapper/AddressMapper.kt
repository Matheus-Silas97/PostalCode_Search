package com.matheussilas97.search.data.mapper

import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.search.data.response.AddressResponse

fun AddressResponse?.toAddressEntity(): Address =
    Address(
        postalCode = this?.postalCode ?: "",
        street = this?.street ?: "",
        complement = this?.complement ?: "",
        neighborhood = this?.neighborhood ?: "",
        city = this?.city ?: "",
        state = this?.state ?: ""
    )