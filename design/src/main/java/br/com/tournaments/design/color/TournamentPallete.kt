package br.com.tournaments.design.color

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

sealed class TournamentPallete {

    object Base : TournamentPallete() {
        val Primary = Color(0xFF512f8b)
        val Secondary = Color(0xFF5f37a2)
        val Dark20 = Color(0xFF282D42)
        val Dark10 = Color(0xFF7a46d1)
        val Base = Color(0xFF874EE8)
        val Light10 = Color(0xFFA276ED)
        val Light20 = Color(0xFFbd9ef2)
        val Light30 = Color(0xFFD8C6F8)
        val Light40 = Color(0xFFF3EDFD)
    }
}