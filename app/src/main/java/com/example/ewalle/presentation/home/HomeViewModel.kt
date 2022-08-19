package com.example.ewalle.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ewalle.data.Friend
import com.example.ewalle.data.RepositoryImpl
import com.example.ewalle.data.ResourceResult
import com.example.ewalle.data.ServiceButtonData
import com.example.ewalle.domain.GetBalanceUseCase
import com.example.ewalle.domain.GetFriendsListUseCase
import com.example.ewalle.domain.GetServicesListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val itemsServices = MutableLiveData<ResourceResult<List<ServiceButtonData>>>()
    val itemsFriends = MutableLiveData<ResourceResult<List<Friend>>>()
    val balance = MutableLiveData<ResourceResult<Long>>()

    private val repository = RepositoryImpl

    private val getBalanceUseCase = GetBalanceUseCase(repository)
    private val getServicesListUseCase = GetServicesListUseCase(repository)
    private val getFriendsListUseCase = GetFriendsListUseCase(repository)

    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val balanceFromRepo = getBalanceUseCase.getBalance()
            balance.postValue(balanceFromRepo)

            val services = getServicesListUseCase.getServicesList()
            itemsServices.postValue(services)

            val friends = getFriendsListUseCase.getFriendsList()
            itemsFriends.postValue(friends)
        }
    }
}