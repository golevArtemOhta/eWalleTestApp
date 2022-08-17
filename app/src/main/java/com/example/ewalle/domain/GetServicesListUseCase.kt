package com.example.ewalle.domain

import com.example.ewalle.data.ResourceResult
import com.example.ewalle.data.ServiceButtonData

class GetServicesListUseCase(private val repository: Repository) {

    fun getServicesList(): ResourceResult<List<ServiceButtonData>> {
        return repository.getServicesList()
    }
}