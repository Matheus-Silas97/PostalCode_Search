package com.matheussilas97.historic.presentation

import com.matheussilas97.common.entity.AddressEntity

data class HistoricAddressState(
    val addressEntity: List<AddressEntity>? = null,
    val saveAddress: Boolean = false,
    val deleteAddress: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)