package com.example.ewalle.presentation.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ewalle.data.ResourceResult
import com.example.ewalle.databinding.ActivityMainBinding
import com.example.ewalle.presentation.home.HomeActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    var login: ResourceResult<Boolean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel.request()
        mainViewModel.stateLogin.observe(this, Observer{
            login = it
        })

        binding.imBtnSignIn.setOnClickListener {
            when (login) {
                is ResourceResult.Success -> openHomeActivity()
                is ResourceResult.Error -> Toast.makeText(
                    this,
                    "Something went wrong",
                    Toast.LENGTH_LONG
                ).show()
                else -> {
                    Toast.makeText(
                        this,
                        "Something went wrong",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        binding.tvCreateAnAccount.setOnClickListener {
            when (login) {
                is ResourceResult.Success -> openHomeActivity()
                is ResourceResult.Error -> Toast.makeText(
                    this,
                    "Something went wrong",
                    Toast.LENGTH_LONG
                ).show()
                else -> {
                    Toast.makeText(
                        this,
                        "Something went wrong",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}