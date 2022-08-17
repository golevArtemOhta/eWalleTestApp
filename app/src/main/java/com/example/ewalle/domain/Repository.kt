package com.example.ewalle.domain

import com.example.ewalle.data.Friend
import com.example.ewalle.data.ResourceResult
import com.example.ewalle.data.ServiceButtonData

interface Repository {

    fun getBalance(): ResourceResult<Long>

    fun getFriendsList(): ResourceResult<List<Friend>>

    fun getServicesList(): ResourceResult<List<ServiceButtonData>>

    fun login(): ResourceResult<Boolean>

}