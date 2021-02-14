package com.example.android.politicalpreparedness.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android.politicalpreparedness.network.models.Election

@Dao
interface ElectionDao {

    //TODO: Add insert query

    @Query("SELECT * FROM election_table")
    suspend fun getElections(): List<Election>

    //TODO: Add select single election query

    //TODO: Add delete query

    //TODO: Add clear query

}