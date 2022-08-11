package br.com.tournaments.home.data.service

import br.com.tournaments.home.data.entity.HomeResultRemote
import retrofit2.http.GET

interface HomeResultService {

    @GET("/teams")
    suspend fun getMatches(): HomeResultRemote
}