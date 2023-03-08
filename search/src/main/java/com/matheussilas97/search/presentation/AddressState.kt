package com.matheussilas97.search.presentation

import com.matheussilas97.common.domain.model.Address

data class AddressState(
    val addressEntity: Address? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)