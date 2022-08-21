package br.com.tournaments.players.data.repository

import br.com.tournaments.network.executor.SafeRequest
import br.com.tournaments.players.data.service.PlayersResultService
import br.com.tournaments.players.domain.repository.PlayersResultRepository

class PlayersResultRepositoryImpl(
    private val playersResultService: PlayersResultService,
    private val safeRequest: SafeRequest
) : PlayersResultRepository {

    override suspend fun getPlayers() = safeRequest {
        playersResultService.getPlayers().transform()
    }
}
