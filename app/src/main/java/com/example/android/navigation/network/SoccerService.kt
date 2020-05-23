package com.example.android.navigation.network

import com.example.android.navigation.model.TeamList
import retrofit2.Call
import retrofit2.http.GET

interface SoccerService {

    @GET("search_all_teams.php?s=Soccer&c=Spain")
    fun getAllTeams() : Call<TeamList>

}