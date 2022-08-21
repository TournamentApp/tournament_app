package br.com.tournaments.players.domain.repository

import br.com.tournaments.network.entity.Result
import br.com.tournaments.players.domain.entity.Player

interface PlayersResultRepository {
    suspend fun getPlayers(): Result<List<Player>>
}
