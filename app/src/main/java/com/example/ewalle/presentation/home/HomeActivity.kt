package com.example.ewalle.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.ewalle.R
import com.example.ewalle.databinding.ActivityHomeBinding
import com.example.ewalle.presentation.other.BlankFragment
import com.example.ewalle.presentation.main.MainActivity
import com.google.android.material.navigation.NavigationView

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

        val navigationView = findViewById<NavigationView>(com.example.ewalle.R.id.nav_view)
        val exitButton = navigationView.getHeaderView(0).findViewById<View>(com.example.ewalle.R.id.imageViewExit) as ImageView
        val logOutButton = navigationView.findViewById<AppCompatButton>(R.id.ButtonLogOut)
        exitButton.setOnClickListener {
            binding.draver.closeDrawer(GravityCompat.START)
        }
        logOutButton.setOnClickListener {
            logOut()
        }
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
        }
        binding.draver.closeDrawer(GravityCompat.START)
        return true
    }

    private fun logOut() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

    }
}