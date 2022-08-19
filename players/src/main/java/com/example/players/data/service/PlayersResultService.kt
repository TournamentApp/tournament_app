package com.example.players.data.service

import com.example.players.data.entity.PlayersResultRemote
import retrofit2.http.GET

interface PlayersResultService {
    @GET("players")
    suspend fun getPlayers(): PlayersResultRemote
}