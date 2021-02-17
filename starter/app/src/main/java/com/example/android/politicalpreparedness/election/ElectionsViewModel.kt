package com.example.android.politicalpreparedness.election

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.politicalpreparedness.election.data.ElectionDataSource
import com.example.android.politicalpreparedness.network.Result
import com.example.android.politicalpreparedness.network.models.Election
import com.example.android.politicalpreparedness.network.models.ElectionResponse
import kotlinx.coroutines.launch

class ElectionsViewModel(private val electionDataSource: ElectionDataSource) : ViewModel() {

    companion object {
        const val TAG = "ElectionsViewModel"
    }

    private val _elections = MutableLiveData<List<Election>>()
    val elections: LiveData<List<Election>>
        get() = _elections

    private val _savedElections = MutableLiveData<List<Election>>()
    val savedElections: LiveData<List<Election>>
        get() = _savedElections

    fun loadData() {
        getElections()
        getSavedElections()
    }

    private fun getElections() {
        viewModelScope.launch {
            when (val result = electionDataSource.getElectionFromApi()) {
                is Result.Success<*> -> {
                    result.data?.let { data ->
                        _elections.value = (data as ElectionResponse).elections
                    }
                }
                is Result.Error -> {
                    Log.e(TAG, result.message)
                }
            }
        }
    }


    private fun getSavedElections() {
        viewModelScope.launch {
            when (val result = electionDataSource.getSavedElection()) {
                is Result.Success<*> -> {
                    result.data?.let { data ->
                        _savedElections.value = data as List<Election>
                    }
                }
                is Result.Error -> {
                    Log.e(TAG, result.message)
                }
            }
        }
    }
}