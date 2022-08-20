package com.example.players.domain.entity

import com.squareup.moshi.Json

data class PlayerResultItemType(
    @field:Json(name = "id") private val id: Int,
    @field:Json(name = "name") private val name: String,
    @field:Json(name = "image") private val image: String? = null,
    @field:Json(name = "created_at") private val createdAt: String,
    @field:Json(name = "person_id") private val personId: String
) {
    fun transform() = Player(
        id, name, image, createdAt, personId
    )
}
