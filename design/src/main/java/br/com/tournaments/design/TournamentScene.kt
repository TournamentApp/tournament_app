package br.com.tournaments.design

import androidx.compose.runtime.Composable
import br.com.tournaments.network.entity.Async

@Composable
fun <T> TournamentScene(
    async: Async<T>,
    loading: @Composable () -> Unit,
    error: @Composable (String) -> Unit,
    content: @Composable (T) -> Unit
) {
    TournamentTheme {
        when(async){
            is Async.Error -> error(async.message)
            Async.Loading -> loading()
            is Async.Success -> content(async.value)
        }
    }
}