package br.com.tournaments.search.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.fragment.findNavController
import br.com.tournaments.design.color.TournamentPalette
import br.com.tournaments.design.typography.SourceSansPro

@ExperimentalMaterialApi
@Composable
fun SearchScreen(
    delegate: SearchDelegate
) {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            modifier = Modifier.padding(start = 40.dp, top = 20.dp),
            text = "Choose an option",
            fontSize = 20.sp,
            color = TournamentPalette.Colors.White,
            fontFamily = SourceSansPro,
            fontWeight = FontWeight.SemiBold
        )
        Card(
            onClick = {
                delegate.navToTeams()
            },
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(150.dp)
                .padding(horizontal = 40.dp, vertical = 10.dp),
            backgroundColor = TournamentPalette.Colors.Secondary
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Teams",
                fontSize = 20.sp,
                color = TournamentPalette.Colors.White,
                fontFamily = SourceSansPro,
                fontWeight = FontWeight.SemiBold
            )
        }
        Card(
            onClick = {
                delegate.navToPlayers()
            },
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(150.dp)
                .padding(horizontal = 40.dp, vertical = 10.dp),
            backgroundColor = TournamentPalette.Colors.Secondary
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Players",
                fontSize = 20.sp,
                color = TournamentPalette.Colors.White,
                fontFamily = SourceSansPro,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
fun SearchScreenPreview() {
    fun searchDelegate() = object : SearchDelegate {
        override fun navToTeams() {}
        override fun navToPlayers() {}
    }
    SearchScreen(searchDelegate())
}
