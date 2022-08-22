package br.com.tournaments.players.presentation

import br.com.tournaments.network.entity.Async
import br.com.tournaments.players.domain.entity.Player

data class PlayersState(
    val players: Async<List<Player>>
)