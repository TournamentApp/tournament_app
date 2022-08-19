package com.example.players.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tournaments.network.entity.Async
import br.com.tournaments.network.entity.onError
import br.com.tournaments.network.entity.onSuccess
import com.example.players.domain.repository.PlayersResultRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlayersViewModel(
    private val playersResultRepository: PlayersResultRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PlayersState(Async.Loading))
    val state: StateFlow<PlayersState> = _state

    fun interact(interaction: PlayersInteractions) {
        when (interaction) {
            is PlayersInteractions.LoadPlayers -> getMatches()
        }
    }

    private fun getMatches() = viewModelScope.launch {
        playersResultRepository.getPlayers()
            .onSuccess { players ->
                _state.update {
                    it.copy(
                        players = Async.Success(players)
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        players = Async.Error(message = error.message)
                    )
                }
            }
    }
}