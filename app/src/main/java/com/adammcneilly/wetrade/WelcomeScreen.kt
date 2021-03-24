package com.adammcneilly.wetrade

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adammcneilly.wetrade.ui.theme.WeTradeTheme

@Composable
fun WelcomeScreen() {

}

@Preview
@Composable
fun PreviewDarkWelcomeScreen() {
    WeTradeTheme(darkTheme = true) {
        WelcomeScreen()
    }
}

@Preview
@Composable
fun PreviewLightWelcomeScreen() {
    WeTradeTheme(darkTheme = false) {
        WelcomeScreen()
    }
}
