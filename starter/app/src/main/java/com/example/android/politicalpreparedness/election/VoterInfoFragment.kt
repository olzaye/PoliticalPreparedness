package com.example.android.politicalpreparedness.election

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.politicalpreparedness.database.ElectionDatabase
import com.example.android.politicalpreparedness.databinding.FragmentVoterInfoBinding
import com.example.android.politicalpreparedness.election.data.ElectionRepository
import com.example.android.politicalpreparedness.network.CivicsApi

class VoterInfoFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this,
                VoterInfoViewModelFactory(ElectionRepository(CivicsApi.retrofitService,
                        ElectionDatabase.getInstance(requireContext()).electionDao))).get(VoterInfoViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding = FragmentVoterInfoBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.voterInfoViewModel = viewModel

        arguments?.let {
            val args = VoterInfoFragmentArgs.fromBundle(it)
            viewModel.passArguments(args.argElectionId, args.argDivision)
        }


        //TODO: Populate voter info -- hide views without provided data.
        /**
        Hint: You will need to ensure proper data is provided from previous fragment.
         */


        //TODO: Handle loading of URLs

        //TODO: Handle save button UI state
        //TODO: cont'd Handle save button clicks
        return binding.root
    }

    //TODO: Create method to load URL intents

}