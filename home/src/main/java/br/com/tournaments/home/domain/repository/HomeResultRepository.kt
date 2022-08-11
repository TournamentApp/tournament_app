package br.com.tournaments.home.domain.repository

import br.com.tournaments.home.domain.entity.HomeResultItemType
import br.com.tournaments.network.entity.Result

interface HomeResultRepository {

    suspend fun getMatches(): Result<List<HomeResultItemType>>
}