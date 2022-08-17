package com.example.ewalle.data

import com.example.ewalle.R

object AllServicesData {
    val allServiceButtonsData: List<ServiceButtonData>
        get() = listOf(
            ServiceButtonData("Send Money", R.drawable.ic_send_money_pict),
            ServiceButtonData("Receive Money", R.drawable.ic_receive_money_pict),
            ServiceButtonData("Mobile Prepaid", R.drawable.ic_mobile),
            ServiceButtonData("Electricity Bill", R.drawable.ic_electrocity_pict),
            ServiceButtonData("Cashback offer", R.drawable.ic_cashback_pict),
            ServiceButtonData("Movie Tickets", R.drawable.ic_movie_tickets_pict),
            ServiceButtonData("Flight Tickets", R.drawable.ic_flight_pict),
            ServiceButtonData("More Options", R.drawable.ic_more_option_pict)
        )
}