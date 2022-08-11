package br.com.tournaments.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.tournaments.home.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.getMatches()

        viewModel.itens.observe(this) { teams ->
            teams.map {
                Log.i("adriano", it.transform().name)
            }

        }
    }
}