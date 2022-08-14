package br.com.tournaments.home.presentation.home

import br.com.tournaments.home.domain.entity.Team
import br.com.tournaments.network.entity.Async

data class HomeState(
    val matches: Async<List<Team>>
)
