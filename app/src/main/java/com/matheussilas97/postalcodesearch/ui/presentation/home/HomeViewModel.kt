package com.matheussilas97.postalcodesearch.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheussilas97.domain.Failure
import com.matheussilas97.domain.Loading
import com.matheussilas97.domain.Resource
import com.matheussilas97.domain.Success
import com.matheussilas97.domain.entity.AddressEntity
import com.matheussilas97.domain.usecase.AddressUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(private val addressUseCase: AddressUseCase) : ViewModel() {

    private val getAddressLiveData = MutableStateFlow<Resource<AddressEntity?>>(Loading())
    val _getAddressLiveData: StateFlow<Resource<AddressEntity?>>
        get() = getAddressLiveData

    fun searchAddress(postalCode: String) {
        viewModelScope.launch {
            getAddressLiveData.value = Loading()
            addressUseCase.searchPostalCode(postalCode = postalCode)
                .onStart {
                    getAddressLiveData.value = Loading()
                }.catch {
                    getAddressLiveData.value = Failure()
                }.collect {
                    getAddressLiveData.value = Success(data = it)
                }
        }
    }

}