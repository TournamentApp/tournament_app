package br.com.tournaments.home.data.entity

import br.com.tournaments.home.domain.entity.HomeResultItemType
import com.squareup.moshi.Json

data class HomeResultRemote(
    @field:Json(name = "data") val teams: List<HomeResultItemType>
) {
    fun transform() = teams.mapNotNull { it.transform() }
}