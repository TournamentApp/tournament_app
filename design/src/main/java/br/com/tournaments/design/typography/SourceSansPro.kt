package br.com.tournaments.design.typography

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import br.com.tournaments.design.R

val SourceSansPro = FontFamily(
    Font(R.font.source_sans_pro_black, weight = FontWeight.Black),
    Font(R.font.source_sans_pro_black_italic, weight = FontWeight.Black, style = FontStyle.Italic),

    Font(R.font.source_sans_pro_bold, weight = FontWeight.Bold),
    Font(R.font.source_sans_pro_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),

    Font(R.font.source_sans_pro_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.source_sans_pro_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),

    Font(R.font.source_sans_pro_regular, weight = FontWeight.Normal),
    Font(R.font.source_sans_pro_italic, weight = FontWeight.Normal, style = FontStyle.Italic),

    Font(R.font.source_sans_pro_light, weight = FontWeight.Light),
    Font(R.font.source_sans_pro_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
)
