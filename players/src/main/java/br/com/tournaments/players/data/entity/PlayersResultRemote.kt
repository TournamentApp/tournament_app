package br.com.tournaments.players.data.entity

import br.com.tournaments.players.domain.entity.PlayerResultItemType
import com.squareup.moshi.Json

data class PlayersResultRemote(
    @field:Json(name = "data") val players: List<PlayerResultItemType>
) {
    fun transform() = players.map { it.transform() }
}
