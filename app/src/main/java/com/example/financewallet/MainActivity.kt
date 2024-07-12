package com.example.financewallet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.financewallet.databinding.ActivityMainBinding
import com.example.financewallet.presentation.assetList.AssetListFragment
import com.example.financewallet.presentation.home.HomeFragment
import com.example.financewallet.presentation.portfolio.PortfolioListFragment
import com.example.financewallet.presentation.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        replaceFragment(HomeFragment())

        val navView:BottomNavigationView=_binding.navigationViewBtm

        val navController= findNavController(R.id.fragment_container_view)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,R.id.navigation_assets, R.id.navigation_portfolio,R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)

        navView.setupWithNavController(navController)

    //        _binding.navigationViewBtm.setOnNavigationItemSelectedListener { item ->
    //            when (item.itemId) {
    //                R.id.navigation_home -> {
    //                    replaceFragment(HomeFragment())
    //                    true
    //                }
    //
    //                R.id.navigation_portfolio -> {
    //                    replaceFragment(PortfolioListFragment())
    //                    true
    //                }
    //
    //                R.id.navigation_assets -> {
    //                    replaceFragment(AssetListFragment())
    //                    true
    //                }
    //
    //                R.id.navigation_settings -> {
    //                    replaceFragment(SettingsFragment())
    //                    true
    //                }
    //
    //                else -> false
    //            }
    //        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.commit()
    }
}
