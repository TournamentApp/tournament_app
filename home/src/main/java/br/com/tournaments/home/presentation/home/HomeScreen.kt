package br.com.tournaments.home.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.tournaments.design.TournamentScene
import br.com.tournaments.design.TournamentTheme
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.interact(HomeInteractions.LoadMatches)
    }

    val state by viewModel.state.collectAsState()

    TournamentTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TournamentScene(
                async = state.matches,
                loading = { Text(text = "Loading") },
                error = {
                    Text(text = it)
                }
            ) { matches ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                ) {
                    matches.forEach { team ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            onClick = { }
                        ) {
                            Text(text = team.name)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}