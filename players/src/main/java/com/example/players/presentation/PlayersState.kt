package com.example.players.presentation

import br.com.tournaments.network.entity.Async
import com.example.players.domain.entity.Player

data class PlayersState(
    val players: Async<List<Player>>
)