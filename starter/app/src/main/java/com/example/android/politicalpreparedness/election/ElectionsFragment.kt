package com.example.android.politicalpreparedness.election

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.politicalpreparedness.database.ElectionDatabase
import com.example.android.politicalpreparedness.databinding.FragmentElectionBinding
import com.example.android.politicalpreparedness.election.adapter.ElectionListAdapter
import com.example.android.politicalpreparedness.election.adapter.ElectionListener
import com.example.android.politicalpreparedness.election.data.ElectionRepository
import com.example.android.politicalpreparedness.network.CivicsApi

class ElectionsFragment : Fragment(), ElectionListener {

    private val viewModel by lazy {
        ViewModelProvider(this,
                ElectionsViewModelFactory(ElectionRepository(CivicsApi.retrofitService,
                        ElectionDatabase.getInstance(requireContext()).electionDao)
                )).get(ElectionsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentElectionBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.electionViewModel = viewModel

        val adapter = ElectionListAdapter(this)
        binding.upcomingElectionsRecyclerView.adapter = adapter
        binding.savedElectionsRecyclerView.adapter = adapter

        return binding.root
    }

    //TODO: Refresh adapters when fragment loads
}