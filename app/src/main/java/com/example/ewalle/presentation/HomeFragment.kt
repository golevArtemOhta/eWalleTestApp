package com.example.ewalle.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ewalle.data.Friend
import com.example.ewalle.data.ResourceResult
import com.example.ewalle.data.ServiceButtonData
import com.example.ewalle.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var servicesItem: ResourceResult<List<ServiceButtonData>>? = null
    var friendsItem: ResourceResult<List<Friend>>? = null
    var balance: ResourceResult<Long>? = null
    lateinit var homeViewModel: HomeViewModel
    private val adapterService = ServiceButtonsAdapter()
    private val adapterFriend = FriendButtonsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.request()

        homeViewModel.balance.observe(activity as LifecycleOwner, Observer {
            balance = it
            when (balance) {
                is ResourceResult.Success -> {
                    val copyBalance = (balance as ResourceResult.Success<Long>).result
                    val balanceAfterTransformation = copyBalance?.div(1000)
                    val balaneString: String =
                        "$balanceAfterTransformation,${copyBalance?.rem(1000)}"
                    binding.tvBalance.text = balaneString.toString()
                }
                is ResourceResult.Error -> TODO()
                else -> {
                    TODO()
                }
            }
        })

        homeViewModel.itemsFriends.observe(activity as LifecycleOwner, Observer {
            friendsItem = it
            when (friendsItem) {
                is ResourceResult.Success -> {
                    adapterFriend.getFriendsButtonData((friendsItem as ResourceResult.Success<List<Friend>>).result)
                    adapterFriend.notifyDataSetChanged()
                }
                is ResourceResult.Error -> TODO()
                else -> {
                    TODO()
                }
            }
        })

        homeViewModel.itemsServices.observe(activity as LifecycleOwner, Observer {
            servicesItem = it
            when (servicesItem) {
                is ResourceResult.Success -> {
                    adapterService.getServiceButtonData((servicesItem as ResourceResult.Success<List<ServiceButtonData>>).result)
                    adapterService.notifyDataSetChanged()
                }
                is ResourceResult.Error -> TODO()
                else -> {
                    TODO()
                }
            }
        })

        binding.recyclerViewPerson.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPerson.adapter = adapterFriend

        binding.recyclerViewServices.layoutManager = GridLayoutManager(context, 4)
        binding.recyclerViewServices.adapter = adapterService
    }


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}