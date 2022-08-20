package com.example.players.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tournaments.design.TournamentScene
import br.com.tournaments.design.TournamentTheme
import br.com.tournaments.design.color.TournamentPalette

import com.example.players.domain.entity.Player
import org.koin.androidx.compose.getViewModel
import com.example.players.R

@Preview
@Composable
fun PlayersScreen(
    viewModel: PlayersViewModel = getViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.interact(PlayersInteractions.LoadPlayers)
    }

    val state by viewModel.state.collectAsState()

    TournamentTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TournamentScene(
                async = state.players,
                loading = { Text(text = "Loading") },
                error = {
                    Text(text = it)
                }
            ) { players ->
                Text(
                    text = "Players",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 5.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                ) {
                    players.forEach { player ->
                        CardPlayer(player)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CardPlayer(player: Player) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(12.dp),
        onClick = { }

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(TournamentPalette.Colors.BackgroundDark)
        ) {
            Image(
                painter = painterResource(id = R.drawable.player),
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp, top = 15.dp)
                    .width(62.dp)
                    .height(62.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, bottom = 12.dp, top = 20.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = player.name,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    text = "Joined in March 26 2021",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PlayersScreenPreview() {
    CardPlayer(
        Player(
            name = "Dr. Dino Abbott",
            id = 12,
            image = "https://avatars.dicebear.com/api/micah/CloydJast.svg?backgroundColor=%234767f9&height=150&width=150",
            createdAt = "",
            personId = "#1234"
        )
    )
}
