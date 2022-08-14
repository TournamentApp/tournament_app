package br.com.tournaments.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.tournaments.home.databinding.ActivityHomeBinding
import br.com.tournaments.home.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val viewModel by viewModel<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.homeNavHostFragment) as NavHostFragment

        navController = navHostFragment.navController

        binding.bottomNavHome.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment)
        )

        binding.toolbarApp.setupWithNavController(navController, appBarConfiguration)

    }
}