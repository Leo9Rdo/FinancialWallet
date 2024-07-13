package com.example.financewallet.presentation.assetList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financewallet.data.AssetRepositoryImpl
import com.example.financewallet.databinding.FragmentAssetListBinding
import com.example.financewallet.domain.repository.AssetRepository
import com.example.financewallet.presentation.rv.AssetAdapter

class AssetListFragment : Fragment() {

    private var _binding: FragmentAssetListBinding? = null
    private val binding get() = _binding!!
    private lateinit var assetAdapter: AssetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAssetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assetAdapter = AssetAdapter()
        binding.assetRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.assetRecyclerView.adapter = assetAdapter

        val assetRepository: AssetRepository = AssetRepositoryImpl()
        assetAdapter.updateList(assetRepository.getAllAssets())
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
