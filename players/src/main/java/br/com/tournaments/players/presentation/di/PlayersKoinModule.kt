package br.com.tournaments.players.presentation.di

import br.com.tournaments.network.ApiServiceFactory
import br.com.tournaments.network.executor.SafeRequest
import br.com.tournaments.players.data.repository.PlayersResultRepositoryImpl
import br.com.tournaments.players.data.service.PlayersResultService
import br.com.tournaments.players.domain.repository.PlayersResultRepository
import br.com.tournaments.players.presentation.PlayersViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectPlayersKoinModule() = loadKoinModule

private val loadKoinModule by lazy {
    loadKoinModules(
        listOf(
            serviceModule,
            repositoryModule,
            viewModelModule
        )
    )
}

private val viewModelModule = module {
    viewModel { PlayersViewModel(get()) }
}
private val repositoryModule = module {
    single<PlayersResultRepository> { PlayersResultRepositoryImpl(get(), get()) }
    factory { SafeRequest(Dispatchers.IO) }
}
private val serviceModule = module {
    single { get<ApiServiceFactory>().create(PlayersResultService::class.java) }
}
