package com.matheussilas97.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheussilas97.common.Failure
import com.matheussilas97.common.Loading
import com.matheussilas97.common.Resource
import com.matheussilas97.common.Success
import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(private val addressUseCase: com.matheussilas97.search.domain.usecase.AddressUseCase) : ViewModel() {

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