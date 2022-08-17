package com.example.ewalle.domain

import com.example.ewalle.data.ResourceResult

class GetBalanceUseCase(private val repository: Repository) {

    fun getBalance(): ResourceResult<Long> {
        return repository.getBalance()
    }
}