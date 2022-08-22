package br.com.tournaments.players.domain.entity

data class Player(
    val id: Int,
    val name: String,
    val image: String? = null,
    val createdAt: String,
    val personId: String
)