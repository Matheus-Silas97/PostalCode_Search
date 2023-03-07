package com.matheussilas97.search.presentation

import com.matheussilas97.common.entity.AddressEntity

data class AddressState(
    val addressEntity: AddressEntity? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)