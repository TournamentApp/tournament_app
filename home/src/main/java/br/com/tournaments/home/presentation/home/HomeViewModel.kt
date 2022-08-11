package br.com.tournaments.home.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tournaments.home.domain.entity.HomeResultItemType
import br.com.tournaments.home.domain.repository.HomeResultRepository
import br.com.tournaments.network.entity.onSuccess
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeResultRepository: HomeResultRepository
) : ViewModel() {

//    val itens = listOf<HomeResultItemType>()
    val itens = MutableLiveData<List<HomeResultItemType>>()

    fun getMatches() {
        viewModelScope.launch {
            homeResultRepository.getMatches().onSuccess { teams ->
                itens.postValue(teams)
            }
        }

    }
}