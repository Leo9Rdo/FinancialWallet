package com.example.financewallet.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.financewallet.presentation.assetList.AssetListFragment
import com.example.financewallet.presentation.portfolio.PortfolioListFragment
import com.example.financewallet.R
import com.example.financewallet.presentation.settings.SettingsFragment
import com.example.financewallet.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            portfolioListBtn.setOnClickListener {
                loadFragment(PortfolioListFragment())
            }
            settingsBtn.setOnClickListener {
                loadFragment(SettingsFragment())
            }
            assetListBtn.setOnClickListener {
                loadFragment(AssetListFragment())
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
