package com.example.financewallet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.financewallet.databinding.ActivityMainBinding
import com.example.financewallet.presentation.assetList.AssetListFragment
import com.example.financewallet.presentation.home.HomeFragment
import com.example.financewallet.presentation.portfolio.PortfolioListFragment
import com.example.financewallet.presentation.settings.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        replaceFragment(HomeFragment())

        _binding.navigationViewBtm.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.portfolio -> {
                    replaceFragment(PortfolioListFragment())
                    true
                }

                R.id.assets -> {
                    replaceFragment(AssetListFragment())
                    true
                }

                R.id.settings -> {
                    replaceFragment(SettingsFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.commit()
    }
}





