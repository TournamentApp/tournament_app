package br.com.tournaments.home.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tournaments.design.TournamentScene
import br.com.tournaments.design.TournamentTheme
import br.com.tournaments.design.color.TournamentPalette
import br.com.tournaments.home.R
import br.com.tournaments.home.domain.entity.Team
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
                Text(
                    text = "Comming up matches",
                    fontSize = 20.sp,
                    color = TournamentPalette.Colors.White,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 5.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                ) {
                    matches.forEach { team ->
                        CardMatch(team)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CardMatch(team: Team) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .width(240.dp)
            .height(280.dp)
            .padding(12.dp),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(TournamentPalette.Colors.BackgroundDark)
        ) {

            Image(
                painter = painterResource(id = R.drawable.game_image),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .width(240.dp)
                    .height(120.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 12.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = team.name,
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    text = "Partidas em mapas diversos",
                    color = Color.White,
                    fontSize = 11.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(end = 15.dp),
                        text = "20.03.2021",
                        color = Color.White,
                        fontSize = 8.sp
                    )
                    Text(
                        modifier = Modifier,
                        text = "9:00 PM",
                        color = Color.White,
                        fontSize = 8.sp
                    )
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = TournamentPalette.Colors.Secondary,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(100.dp)
                        .padding(end = 15.dp)
                        .align(End),
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Assign", fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    CardMatch(
        Team(
            id = 1,
            name = "Skill Shortage",
            tag = "SSA",
            description = "A",
            image = null,
            user_id = 1
        )
    )
}