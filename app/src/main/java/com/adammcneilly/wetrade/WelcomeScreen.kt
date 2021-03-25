package com.adammcneilly.wetrade

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.outlinedButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.wetrade.ui.theme.WeTradeTheme

@Composable
fun WelcomeScreen(
    navController: NavController,
) {
    Box {
        WelcomeBackground()

        AppLogo(
            modifier = Modifier
                .align(Alignment.Center)
        )

        WelcomeButtonRow(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
                .height(48.dp),
            navController = navController,
        )
    }
}

@Composable
private fun WelcomeBackground() {
    Image(
        painterResource(id = R.drawable.ic_welcome_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Composable
private fun AppLogo(
    modifier: Modifier,
) {
    Image(
        painterResource(id = R.drawable.ic_logo),
        contentDescription = "WeTrade Logo",
        modifier = modifier,
    )
}

@Composable
private fun GetStartedButton(modifier: Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
        modifier = modifier
    ) {
        Text("GET STARTED")
    }
}

@Composable
private fun LogInButton(
    modifier: Modifier,
    navController: NavController,
) {
    val buttonColors = outlinedButtonColors(
        backgroundColor = Color.Transparent,
    )

    val buttonBorder = BorderStroke(
        width = 1.dp,
        color = MaterialTheme.colors.primary,
    )

    OutlinedButton(
        onClick = {
            navController.navigate("login")
        },
        shape = MaterialTheme.shapes.large,
        colors = buttonColors,
        border = buttonBorder,
        modifier = modifier,
    ) {
        Text("LOG IN")
    }
}

@Composable
private fun WelcomeButtonRow(
    modifier: Modifier,
    navController: NavController,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        val buttonModifier = Modifier
            .weight(1F)
            .fillMaxHeight()

        GetStartedButton(
            modifier = buttonModifier
        )

        LogInButton(
            modifier = buttonModifier,
            navController = navController,
        )
    }
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
private fun WelcomeScreenPreview() {
    WeTradeTheme {
        WelcomeScreen(rememberNavController())
    }
}
