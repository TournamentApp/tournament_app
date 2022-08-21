package br.com.tournaments.account.signin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tournaments.design.color.TournamentPalette
import br.com.tournaments.design.input.TournamentInput
import br.com.tournaments.design.typography.SourceSansPro
import br.com.tournaments.design.R

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.ic_scrimsapp_background_dark),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(top = 10.dp)
                .align(CenterHorizontally),
            contentDescription = ""
        )
        Text(
            modifier = Modifier.padding(start = 40.dp, top = 20.dp),
            text = "Welcome back!",
            fontFamily = SourceSansPro,
            fontSize = 20.sp,
            color = TournamentPalette.Colors.White
        )
        Text(
            modifier = Modifier.padding(start = 40.dp, top = 36.dp),
            text = "Sign in with your account",
            fontFamily = SourceSansPro,
            fontSize = 16.sp,
            color = TournamentPalette.Colors.White
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 20.dp)
        ) {
            var email by remember { mutableStateOf("") }
            TournamentInput(
                label = "EMAIL",
                placeholder = "",
                text = email,
                onTextChange = { email = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            var password by remember { mutableStateOf("") }
            TournamentInput(
                label = "PASSWORD",
                placeholder = "",
                text = password,
                onTextChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TournamentPalette.Colors.Primary,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Sign in",
                    fontSize = 20.sp,
                    fontFamily = SourceSansPro
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
                .clickable {

                },
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Dont’t have an account?",
                color = TournamentPalette.Colors.Gray
            )
            Text(
                text = " Register here",
                color = TournamentPalette.Colors.Gray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF101424)
fun SignInScreenPreview() {
    SignInScreen()
}