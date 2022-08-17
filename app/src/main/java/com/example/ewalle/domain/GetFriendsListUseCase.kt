package com.example.ewalle.domain

import com.example.ewalle.data.Friend
import com.example.ewalle.data.ResourceResult

class GetFriendsListUseCase(private val repository: Repository) {

    fun getFriendsList(): ResourceResult<List<Friend>> {
        return repository.getFriendsList()
    }
}