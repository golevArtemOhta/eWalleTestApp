package com.example.ewalle.presentation

import android.os.Bundle
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.ewalle.R
import com.example.ewalle.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            openFragment(HomeFragment.newInstance(), null)
        }

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer { isConnected ->
            if (isConnected) {
                Toast.makeText(this, "Internet is connected", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Internet is not connected", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun openFragment(fragment: Fragment, tagName: String?) {
        if (supportFragmentManager.findFragmentByTag(tagName) == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, fragment)
                .commit()
        }
    }

    private fun openFragmentWithAnimation(fragment: Fragment, tagName: String?) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.fragment_animation)
        openFragment(fragment, tagName)
        binding.fragment.animation = animation
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> openFragmentWithAnimation(HomeFragment.newInstance(), "home")
            R.id.profile -> openFragmentWithAnimation(
                BlankFragment.newInstance(item.title.toString()),
                "profile"
            )
            R.id.accounts -> openFragmentWithAnimation(
                BlankFragment.newInstance(item.title.toString()),
                "accounts"
            )
            R.id.transactions -> openFragmentWithAnimation(
                BlankFragment.newInstance(item.title.toString()),
                "transactions"
            )
            R.id.stats -> openFragmentWithAnimation(
                BlankFragment.newInstance(item.title.toString()),
                "stats"
            )
            R.id.settings -> openFragmentWithAnimation(
                BlankFragment.newInstance(item.title.toString()),
                "settings"
            )
            R.id.help -> openFragmentWithAnimation(
                BlankFragment.newInstance(item.title.toString()),
                "help"
            )
            R.id.imageViewExit -> binding.draver.closeDrawer(GravityCompat.START)
        }
        binding.draver.closeDrawer(GravityCompat.START)
        return true
    }
}