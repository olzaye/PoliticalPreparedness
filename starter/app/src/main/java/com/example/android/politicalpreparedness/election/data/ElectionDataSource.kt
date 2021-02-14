package com.example.android.politicalpreparedness.election.data

import com.example.android.politicalpreparedness.network.Result
import com.example.android.politicalpreparedness.network.models.Election
import com.example.android.politicalpreparedness.network.models.ElectionResponse

interface ElectionDataSource {
    suspend fun getElectionFromApi(): Result<ElectionResponse>
    suspend fun getSavedElection(): Result<List<Election>>
    suspend fun saveElection(reminder: Election): Result<List<Election>>
    suspend fun deleteElectionById(id: Int)
}