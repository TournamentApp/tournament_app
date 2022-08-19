package br.com.tournaments

import android.app.Application
import br.com.tournaments.home.presentation.di.injectHomeKoinModule
import br.com.tournaments.network.injectNetworkKoinModule
import com.example.players.presentation.di.injectPlayersKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun startKoin(myApplication: Application) {

    startKoin {
        androidContext(myApplication)
    }

    injectModules()
}

fun injectModules() {
    injectNetworkKoinModule()
    injectHomeKoinModule()
    injectPlayersKoinModule()
}