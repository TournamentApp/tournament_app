package br.com.tournaments.home.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tournaments.home.domain.entity.HomeResultItemType
import br.com.tournaments.home.domain.repository.HomeResultRepository
import br.com.tournaments.network.entity.Async
import br.com.tournaments.network.entity.onError
import br.com.tournaments.network.entity.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeResultRepository: HomeResultRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(Async.Loading))
    val state: StateFlow<HomeState> = _state

    fun interact(interaction: HomeInteractions) {
        when (interaction) {
            is HomeInteractions.LoadMatches -> getMatches()
        }
    }

    //    val itens = listOf<HomeResultItemType>()
    val itens = MutableLiveData<List<HomeResultItemType>>()

    private fun getMatches() = viewModelScope.launch {
        homeResultRepository.getMatches()
            .onSuccess { teams ->
                _state.update {
                    it.copy(
                        matches = Async.Success(teams)
                    )
                }
            }
            .onError {

            }
    }

}