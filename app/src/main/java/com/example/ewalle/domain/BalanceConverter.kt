package com.example.ewalle.domain

import com.example.ewalle.data.Balance
import com.example.ewalle.data.ResourceResult

interface BalanceConverter {
    companion object {
        fun balanceConverter(balance: Long): String{
            val balanceAfterTransformation = balance?.div(1000)
            val balaneString: String =
                "$balanceAfterTransformation,${balance?.rem(1000)}"
            return balaneString
        }

    }
}