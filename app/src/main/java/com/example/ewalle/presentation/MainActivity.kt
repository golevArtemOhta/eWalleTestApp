package com.example.ewalle.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ewalle.data.RepositoryImpl
import com.example.ewalle.data.ResourceResult
import com.example.ewalle.databinding.ActivityMainBinding
import com.example.ewalle.domain.LoginUseCase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val repository = RepositoryImpl
    private val loginUseCase = LoginUseCase(repository)
    val login = loginUseCase.login()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imBtnSignIn.setOnClickListener {
            when (login) {
                is ResourceResult.Success -> openHomeActivity()
                is ResourceResult.Error -> Toast.makeText(
                    this,
                    "Something went wrong",
                    Toast.LENGTH_LONG
                ).show()
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
            }
        }
    }

    private fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}