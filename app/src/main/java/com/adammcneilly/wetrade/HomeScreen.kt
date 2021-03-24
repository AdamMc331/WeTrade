package com.adammcneilly.wetrade

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adammcneilly.wetrade.ui.theme.WeTradeTheme

@Composable
fun HomeScreen() {

}

@Preview
@Composable
fun PreviewDarkHomeScreen() {
    WeTradeTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview
@Composable
fun PreviewLightHomeScreen() {
    WeTradeTheme(darkTheme = false) {
        HomeScreen()
    }
}
