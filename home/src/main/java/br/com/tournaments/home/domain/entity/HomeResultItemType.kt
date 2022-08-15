package br.com.tournaments.home.domain.entity

import com.squareup.moshi.Json

data class HomeResultItemType(
    @field:Json(name = "id") private val id: Int,
    @field:Json(name = "name") private val name: String,
    @field:Json(name = "tag") private val tag: String,
    @field:Json(name = "description") private val description: String,
    @field:Json(name = "image") private val image: String? = null,
    @field:Json(name = "user_id") private val user_id: Int
) {
    fun transform() = Team(
        id, name, tag, description, image, user_id
    )
}
