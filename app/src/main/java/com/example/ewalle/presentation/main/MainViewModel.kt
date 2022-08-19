package com.example.ewalle.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ewalle.data.RepositoryImpl
import com.example.ewalle.data.ResourceResult
import com.example.ewalle.domain.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val stateLogin = MutableLiveData<ResourceResult<Boolean>>()

    private val repository = RepositoryImpl
    private val loginUseCase = LoginUseCase(repository)

    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val login = loginUseCase.login()
            stateLogin.postValue(login)
        }
    }
}