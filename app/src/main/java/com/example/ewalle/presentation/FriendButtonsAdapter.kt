package com.example.ewalle.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ewalle.R
import com.example.ewalle.data.Friend
import com.example.ewalle.databinding.PersonItemBinding

class FriendButtonsAdapter : RecyclerView.Adapter<FriendButtonsAdapter.FriendButtonHolder>() {
    val FriendsButtonsList = ArrayList<Friend>()

    class FriendButtonHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = PersonItemBinding.bind(item)

        @SuppressLint("SetTextI18n")
        fun bind(friend: Friend) = with(binding) {
            imAvatar.load(friend.avatarOfFriend)
            tvName.text = friend.nameOfFriend
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendButtonHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item, parent, false)
        return FriendButtonHolder(view)
    }

    override fun onBindViewHolder(holder: FriendButtonHolder, position: Int) {
        holder.bind(FriendsButtonsList[position])
    }

    override fun getItemCount(): Int {
        return FriendsButtonsList.size
    }

    fun getFriendsButtonData(personButtons: List<Friend>) {
        FriendsButtonsList.clear()
        FriendsButtonsList.addAll(personButtons)
    }
}