package com.example.android.politicalpreparedness.election

import android.util.Log
import androidx.lifecycle.*
import com.example.android.politicalpreparedness.network.Result
import com.example.android.politicalpreparedness.election.data.ElectionDataSource
import com.example.android.politicalpreparedness.network.models.Division
import com.example.android.politicalpreparedness.network.models.VoterInfoResponse
import kotlinx.coroutines.launch

class VoterInfoViewModel(private val electionDataSource: ElectionDataSource) : ViewModel() {

    private val _voterInfo = MutableLiveData<VoterInfoResponse>()
    val voterInfo: LiveData<VoterInfoResponse>
        get() = _voterInfo

    val toolbarTitle = Transformations.map(voterInfo) {
        it.election.name
    }

    //TODO: Add var and methods to support loading URLs

    //TODO: Add var and methods to save and remove elections to local database
    //TODO: cont'd -- Populate initial state of save button to reflect proper action based on election saved status

    /**
     * Hint: The saved state can be accomplished in multiple ways. It is directly related to how elections are saved/removed from the database.
     */

    fun passArguments(argElectionId: Int, argDivision: Division) {
        viewModelScope.launch {
            val result = electionDataSource.getVoterInfo(mapOf(
                    "electionId" to argElectionId,
                    "address" to "${argDivision.country}, ${argDivision.state}"
            ))

            when (result) {
                is Result.Success<*> -> {
                    result.data?.let {
                        _voterInfo.value = it as VoterInfoResponse
                    } ?: run {
                        //show toast
                    }
                }
                is Result.Error -> {
                    Log.e("VoterInfoViewModel", result.message)
                }
            }
        }
    }

    fun onSaveElection() {

    }
}