package com.example.players.data.entity

import com.example.players.domain.entity.PlayerResultItemType
import com.squareup.moshi.Json

data class PlayersResultRemote(
    @field:Json(name = "data") val players: List<PlayerResultItemType>
) {
    fun transform() = players.map { it.transform() }
}