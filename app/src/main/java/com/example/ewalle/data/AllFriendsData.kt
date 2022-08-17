package com.example.ewalle.data

import com.example.ewalle.R

object AllFriendsData {
    val allFriendsButtonsData: List<Friend>
        get() = listOf(
            Friend("Mike", R.drawable.ic_mike_avatar, 0),
            Friend("Joshpeh", R.drawable.ic_joshpeh_avatar, 1),
            Friend("Ashley", R.drawable.ic_ashley_avatar, 2)
        )
}