package br.com.tournaments.home.domain.entity

import com.squareup.moshi.Json

data class HomeResultItemType(
    @field:Json(name = "id") private val id: Int,
    @field:Json(name = "name") private val name: String,
    @field:Json(name = "id") private val tag: String,
    @field:Json(name = "id") private val description: String,
    @field:Json(name = "id") private val image: String,
    @field:Json(name = "id") private val user_id: Int
) {
    fun transform() = Team(
        id, name, tag, description, image, user_id
    )
}
