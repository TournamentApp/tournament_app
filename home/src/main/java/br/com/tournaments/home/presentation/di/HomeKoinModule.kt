package br.com.tournaments.home.presentation.di

import br.com.tournaments.home.data.repository.HomeResultRepositoryImpl
import br.com.tournaments.home.data.service.HomeResultService
import br.com.tournaments.home.domain.repository.HomeResultRepository
import br.com.tournaments.home.presentation.home.HomeViewModel
import br.com.tournaments.network.ApiServiceFactory
import br.com.tournaments.network.executor.SafeRequest
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectHomeKoinModule() = loadKoinModule

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
    viewModel { HomeViewModel(get()) }
}
private val repositoryModule = module {
    single<HomeResultRepository> { HomeResultRepositoryImpl(get(), get()) }
    factory { SafeRequest(Dispatchers.IO) }
}
private val serviceModule = module {
    single { get<ApiServiceFactory>().create(HomeResultService::class.java) }
}