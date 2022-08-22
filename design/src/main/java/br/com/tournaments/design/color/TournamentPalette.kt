package br.com.tournaments.design.color

import androidx.compose.ui.graphics.Color

sealed class TournamentPalette {

    object Colors : TournamentPalette() {
        val Primary = Color(0xFF9161FF)
        val Secondary = Color(0xFF4767F9)
        val BackgroundLittleDark = Color(0xFF192039)
        val BackgroundDark = Color(0xFF101424)
        val BackgroundBackup = Color(0xFFE1E1E1)
        val BackgroundLight = Color(0xFFF8F8F8)
        val Green = Color(0xFF5ACA73)
        val Pink = Color(0xFFFE54A1)
        val White = Color(0xFFFFFFFF)
        val Black = Color(0xFF000000)
        val Transparent = Color(0x00000000)
        val Gray = Color(0xFFF1F1F1)
        val BackgroundInput = Color(0xFF1F2333)
    }
}