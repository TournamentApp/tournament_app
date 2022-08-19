package com.example.players.presentation.di

import br.com.tournaments.network.ApiServiceFactory
import br.com.tournaments.network.executor.SafeRequest
import com.example.players.data.repository.PlayersResultRepositoryImpl
import com.example.players.data.service.PlayersResultService
import com.example.players.domain.repository.PlayersResultRepository
import com.example.players.presentation.PlayersViewModel
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