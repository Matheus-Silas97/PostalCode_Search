package com.matheussilas97.historic.presentation

import com.matheussilas97.common.domain.model.Address

data class HistoricAddressState(
    val addressEntity: List<Address>? = null,
    val isLoading: Boolean = false,
    val showDeleteAddressDialog: Boolean = false,
    val addressForDelete: Address? = null,
    val error: String? = null
)