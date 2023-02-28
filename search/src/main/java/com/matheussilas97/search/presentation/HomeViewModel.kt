package com.matheussilas97.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheussilas97.search.domain.AddressState
import com.matheussilas97.search.domain.usecase.AddressUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val addressUseCase: AddressUseCase) : ViewModel() {

    private val state = MutableStateFlow(AddressState(isLoading = true))
    val _state: StateFlow<AddressState> = state

    fun interact(interaction: SearchAddressInteraction) {
        when (interaction) {
            is SearchAddressInteraction.SearchAddress -> searchAddress(interaction.postalCode)
        }
    }

    private fun searchAddress(postalCode: String) {
        viewModelScope.launch {
            addressUseCase.searchPostalCode(postalCode = postalCode)
                .onStart {
                    state.update { AddressState(addressEntity = null, isLoading = true, error = null) }
                }.catch { throwable ->
                    state.update { AddressState(addressEntity = null, isLoading = false, error = throwable.message) }
                }.collect {
                    state.update { AddressState(addressEntity = it.addressEntity, isLoading = false, error = null) }
                }
        }
    }

}