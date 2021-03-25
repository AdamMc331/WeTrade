package com.adammcneilly.wetrade

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.wetrade.ui.theme.WeTradeTheme
import com.adammcneilly.wetrade.ui.theme.White

@Composable
fun LoginScreen(navController: NavController) {
    val backgroundColor = if (MaterialTheme.colors.isLight) {
        MaterialTheme.colors.surface
    } else {
        MaterialTheme.colors.background
    }

    Surface(
        color = backgroundColor,
        modifier = Modifier
            .fillMaxSize()
    ) {
        LoginScreenContent(navController)

        WelcomeBackHeader()
    }
}

@Composable
private fun WelcomeBackHeader() {
    Text(
        "Welcome\nback",
        style = MaterialTheme.typography.h2,
        color = White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(152.dp)
    )
}

@Composable
private fun LoginScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LoginBackground()

        Spacer(modifier = Modifier.height(40.dp))

        EmailInput()

        Spacer(modifier = Modifier.height(8.dp))

        PasswordInput()

        Spacer(modifier = Modifier.height(16.dp))

        LogInButton(navController)
    }
}

@Composable
private fun LogInButton(
    navController: NavController,
) {
    Button(
        onClick = {
            navController.navigate("home")
        },
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp)
    ) {
        Text("LOG IN")
    }
}

@Composable
private fun EmailInput() {
    val text = remember { mutableStateOf("") }

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = {
            Text("Email address")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
        ),
        leadingIcon = {
            Icon(
                Icons.Outlined.Email,
                contentDescription = null,
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Composable
private fun PasswordInput() {
    val text = remember { mutableStateOf("") }

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = {
            Text("Password")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
        ),
        leadingIcon = {
            Icon(
                Icons.Default.Password,
                contentDescription = null,
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Composable
private fun LoginBackground() {
    Image(
        painterResource(id = R.drawable.ic_login_bg),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun LoginScreenPreview() {
    WeTradeTheme(darkTheme = true) {
        LoginScreen(rememberNavController())
    }
}
