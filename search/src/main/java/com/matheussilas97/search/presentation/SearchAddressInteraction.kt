package com.matheussilas97.search.presentation

sealed class SearchAddressInteraction {

    data class SearchAddress(val postalCode: String) : SearchAddressInteraction()

    object CloseDialog : SearchAddressInteraction()

}