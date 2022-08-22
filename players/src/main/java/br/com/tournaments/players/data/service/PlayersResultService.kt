package br.com.tournaments.players.data.service

import br.com.tournaments.players.data.entity.PlayersResultRemote
import retrofit2.http.GET

interface PlayersResultService {
    @GET("players")
    suspend fun getPlayers(): PlayersResultRemote
}
