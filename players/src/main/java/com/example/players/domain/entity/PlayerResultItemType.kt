package com.example.players.domain.entity

import com.squareup.moshi.Json

data class PlayerResultItemType(

    @field:Json(name = "id") private val id: Int,
    @field:Json(name = "name") private val name: String,
    @field:Json(name = "image") private val image: String? = null,

    ) {
    fun transform() = Player(
        id, name, image
    )
}
