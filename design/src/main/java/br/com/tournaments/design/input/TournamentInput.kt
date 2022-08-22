package br.com.tournaments.design.input

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tournaments.design.color.TournamentPalette
import br.com.tournaments.design.typography.SourceSansPro

@Composable
fun TournamentInput(
    modifier: Modifier = Modifier,
    label: String = "",
    text: String = "",
    placeholder: String = "",
    isError: Boolean = false,
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        textStyle = TextStyle(
            color = TournamentPalette.Colors.Gray,
            fontFamily = SourceSansPro,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        ),
        placeholder = {
            Text(
                text = placeholder,
                color = TournamentPalette.Colors.Gray,
                fontFamily = SourceSansPro,
                fontSize = TextUnit.Unspecified,
                fontWeight = FontWeight.Normal
            )
        },
        label = {
            Text(
                text = label,
                color = TournamentPalette.Colors.Gray,
                fontFamily = SourceSansPro,
                fontSize = TextUnit.Unspecified,
                fontWeight = FontWeight.Normal)
        },
        onValueChange = { onTextChange.invoke(it) },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = TournamentPalette.Colors.White,
            focusedLabelColor = TournamentPalette.Colors.Gray,
            focusedBorderColor = TournamentPalette.Colors.Primary,
            cursorColor = TournamentPalette.Colors.Gray,
            unfocusedBorderColor = TournamentPalette.Colors.Transparent,
            unfocusedLabelColor = TournamentPalette.Colors.Gray,
            placeholderColor = TournamentPalette.Colors.Gray,
            backgroundColor = TournamentPalette.Colors.BackgroundInput
        ),
        isError = isError,
        enabled = isEnabled,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@Composable
@Preview(showBackground = true)
fun TournamentInputPreview(){
    var preview by remember { mutableStateOf("") }
    TournamentInput(
        placeholder = "Preview",
        text = preview,
        onTextChange = { preview = it }
    )
}