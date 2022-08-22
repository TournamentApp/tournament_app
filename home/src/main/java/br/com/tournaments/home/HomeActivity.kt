package br.com.tournaments.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.tournaments.design.TournamentTheme
import br.com.tournaments.home.databinding.ActivityHomeBinding
import br.com.tournaments.home.presentation.home.*
import br.com.tournaments.home.presentation.menu.AppBar
import br.com.tournaments.home.presentation.menu.Drawer
import br.com.tournaments.home.presentation.menu.DrawerBody
import br.com.tournaments.home.presentation.menu.MenuItems
import kotlinx.coroutines.launch
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

//        binding.toolbarApp.setupWithNavController(navController, appBarConfiguration)

        binding.toolbarApp.setContent {
            TournamentTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        Drawer()
                        DrawerBody(
                            items = listOf(
                                MenuItems(
                                    profileName = "Giovani Rodrigues",
                                    profileImage = R.drawable.game_image
                                ),
                            ),
                            onItemClick = {
                                println("Clicked on ${it.profileName}")
                            }
                        )
                    }
                ) {
                }
            }
        }

    }
}

