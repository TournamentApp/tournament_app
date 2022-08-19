package com.example.players.data.repository

import br.com.tournaments.network.executor.SafeRequest
import com.example.players.data.service.PlayersResultService
import com.example.players.domain.repository.PlayersResultRepository

class PlayersResultRepositoryImpl(
    private val playersResultService: PlayersResultService,
    private val safeRequest: SafeRequest
) : PlayersResultRepository {

    override suspend fun getPlayers() = safeRequest {
        playersResultService.getPlayers().transform()
    }

}