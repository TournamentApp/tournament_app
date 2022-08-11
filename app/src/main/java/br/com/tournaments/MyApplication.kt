package br.com.tournaments

import android.app.Application
import android.content.Intent
import br.com.tournaments.home.HomeActivity

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this)
        redirectToHome(this)
    }

    private fun redirectToHome(myApplication: MyApplication) {
        val intent = Intent(myApplication.applicationContext, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}