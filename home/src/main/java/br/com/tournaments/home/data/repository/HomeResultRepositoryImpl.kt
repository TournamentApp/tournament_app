package br.com.tournaments.home.data.repository

import br.com.tournaments.home.data.service.HomeResultService
import br.com.tournaments.home.domain.repository.HomeResultRepository
import br.com.tournaments.network.executor.SafeRequest

class HomeResultRepositoryImpl(
    private val homeResultService: HomeResultService,
    private val safeRequest: SafeRequest
): HomeResultRepository {

    override suspend fun getMatches() = safeRequest{
        homeResultService.getMatches().transform()
    }

}