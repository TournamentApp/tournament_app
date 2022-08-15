package br.com.tournaments.home.domain.entity

data class Team(
    val id: Int,
    val name: String,
    val tag: String,
    val description: String,
    val image: String? = null,
    val user_id: Int
)
