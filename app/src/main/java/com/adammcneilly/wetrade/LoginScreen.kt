package com.adammcneilly.wetrade

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adammcneilly.wetrade.ui.theme.WeTradeTheme

@Composable
fun LoginScreen() {

}

@Preview
@Composable
fun PreviewDarkLoginScreen() {
    WeTradeTheme(darkTheme = true) {
        LoginScreen()
    }
}

@Preview
@Composable
fun PreviewLightLoginScreen() {
    WeTradeTheme(darkTheme = false) {
        LoginScreen()
    }
}
