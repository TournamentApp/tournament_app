package br.com.tournaments.home.presentation.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tournaments.design.color.TournamentPalette
import br.com.tournaments.home.R


@Composable
fun Drawer() {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .fillMaxWidth()
            .background(TournamentPalette.Colors.BackgroundDark)
    ) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            modifier = Modifier
                .clickable { }
                .background(TournamentPalette.Colors.BackgroundDark)
                .width(30.dp)
                .height(30.dp)
                .padding(end = 5.dp, top = 5.dp)
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(TournamentPalette.Colors.BackgroundDark)
            .padding(vertical = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.avatar_image),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(80.dp)),
        )
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(TournamentPalette.Colors.BackgroundDark)
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(bottom = 32.dp)
            ) {
                Text(
                    text = item.profileName,
                    textAlign = TextAlign.Center,
                    color = TournamentPalette.Colors.White
                )
            }
            Column(
                modifier = Modifier
                    .background(TournamentPalette.Colors.BackgroundDark)
                    .padding(start = 32.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 15.dp)
                        .width(100.dp)
                        .clickable { }
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .padding(end = 10.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Profile", fontSize = 20.sp,
                        color = TournamentPalette.Colors.White
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .width(100.dp)
                        .padding(vertical = 15.dp)
                        .clickable { }
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_support_agent),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .padding(end = 10.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Support", fontSize = 20.sp,
                        color = TournamentPalette.Colors.White
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .width(100.dp)
                        .padding(vertical = 15.dp)
                        .clickable { }
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = null,
                        modifier = Modifier
                            .width(35.dp)
                            .padding(end = 10.dp)
                            .height(35.dp)
                    )
                    Text(
                        text = "Settings", fontSize = 20.sp,
                        color = TournamentPalette.Colors.White
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .width(100.dp)
                        .padding(vertical = 15.dp)
                        .clickable { }
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .padding(end = 10.dp)
                            .height(30.dp)
                    )
                    Text(
                        text = "Logout", fontSize = 20.sp,
                        color = TournamentPalette.Colors.White
                    )
                }
                Box(
                    modifier = Modifier
                        .background(TournamentPalette.Colors.BackgroundDark)
                        .fillParentMaxSize()
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
                    imageVector = Icons.Default.Menu, contentDescription = "Menu"
                )
            }
        }
    )
}
