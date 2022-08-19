package com.example.players.domain.repository

import br.com.tournaments.network.entity.Result
import com.example.players.domain.entity.Player

interface PlayersResultRepository {
    suspend fun getPlayers(): Result<List<Player>>
}