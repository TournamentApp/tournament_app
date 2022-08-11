package br.com.tournaments.network

import br.com.tournaments.network.executor.SafeRequest
import br.com.tournaments.network.httpclient.OkHttpClientFactory
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectNetworkKoinModule() = loadKoinModule

private val loadKoinModule by lazy {
    loadKoinModules(
        module {
            factory<OkHttpClientFactory> {
                ApiOkHttpClientFactory()
            }
            factory { SafeRequest(Dispatchers.IO) }
            single { ApiServiceFactory(get()) }
        }
    )
}