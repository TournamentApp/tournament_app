package br.com.tournaments.design

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TournamentTheme(content: @Composable () -> Unit){
    MaterialTheme(
        content = content
    )
}