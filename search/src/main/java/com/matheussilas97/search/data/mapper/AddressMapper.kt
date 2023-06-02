package com.matheussilas97.search.data.mapper

import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.search.data.response.AddressResponse

fun AddressResponse?.toAddressEntity(): Address =
    Address(
        postalCode = this?.postalCode.orEmpty(),
        street = this?.street.orEmpty(),
        complement = this?.complement.orEmpty(),
        neighborhood = this?.neighborhood.orEmpty(),
        city = this?.city.orEmpty(),
        state = this?.state.orEmpty()
    )