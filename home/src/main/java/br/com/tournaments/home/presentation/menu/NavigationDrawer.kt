package br.com.tournaments.home.presentation.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tournaments.design.color.TournamentPalette


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Drawer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Menu", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItems>,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItems) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon, contentDescription = item.title
                )
                Spacer(
                    modifier = Modifier.width(16.dp)
                )
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f)
                )
            }

        }
    }
}

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Home")
        },
        backgroundColor = TournamentPalette.Colors.BackgroundDark,
        contentColor = TournamentPalette.Colors.Secondary,

        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu, contentDescription = "teste"
                )
            }
        }
    )
}
