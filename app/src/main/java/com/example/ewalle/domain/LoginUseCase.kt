package com.example.ewalle.domain

import com.example.ewalle.data.ResourceResult

class LoginUseCase(private val repository: Repository) {
    fun login(): ResourceResult<Boolean> {
        return repository.login()
    }

}