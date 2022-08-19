package com.example.ewalle.data

import com.example.ewalle.domain.Repository

object RepositoryImpl : Repository {

    override fun getBalance(): ResourceResult<Long> {
        return ResourceResult.Success(Balance.balance.balance)
    }

    override fun getFriendsList(): ResourceResult<List<Friend>> {
        return ResourceResult.Success(AllFriendsData.allFriendsButtonsData)
    }

    override fun getServicesList(): ResourceResult<List<ServiceButtonData>> {
        return ResourceResult.Success(AllServicesData.allServiceButtonsData)
    }

    override fun login(): ResourceResult<Boolean> {
        return try {
            ResourceResult.Success(true)
        } catch (e: Exception) {
            ResourceResult.Error(e)
        }
    }


}

