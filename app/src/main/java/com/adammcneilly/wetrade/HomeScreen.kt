package com.adammcneilly.wetrade

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.More
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.wetrade.ui.theme.Green
import com.adammcneilly.wetrade.ui.theme.WeTradeTheme
import com.adammcneilly.wetrade.ui.theme.White

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    BottomSheetScaffold(
        sheetContent = {
            StockPositionListSheet()
        },
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetPeekHeight = 64.dp,
        sheetShape = RectangleShape,
    ) { paddingValues ->
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            HomeScreenContent()
        }
    }
}

@Composable
private fun HomeScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeScreenTabRow()

        Spacer(modifier = Modifier.height(8.dp))

        BalanceSubtitle()

        Spacer(modifier = Modifier.height(8.dp))

        AccountBalanceHeader()

        Spacer(modifier = Modifier.height(24.dp))

        BalanceChangeSubtitle()

        Spacer(modifier = Modifier.height(32.dp))

        TransactButton()

        Spacer(modifier = Modifier.height(16.dp))

        FilterButtonRow()

        ChartImage()
    }
}

@Composable
private fun TransactButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text("TRANSACT")
    }
}

@Composable
private fun ChartImage() {
    Image(
        painterResource(id = R.drawable.ic_home_illos),
        contentDescription = "Some Chart",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 32.dp)
    )
}

@Composable
private fun FilterButtonRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(40.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        FilterButton("Week", icon = Icons.Default.ExpandMore)
        FilterButton("EFTs")
        FilterButton("Stocks")
        FilterButton("Funds")
        FilterButton("NFTs")
    }
}

@Composable
private fun FilterButton(
    buttonText: String,
    icon: ImageVector? = null,
) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent,
            contentColor = White,
        ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, White),
        modifier = Modifier
            .fillMaxHeight(),
    ) {
        Text(
            buttonText,
            style = MaterialTheme.typography.body1,
        )

        if (icon != null) {
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                icon,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun BalanceSubtitle() {
    Text(
        "Balance",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
    )
}

@Composable
private fun AccountBalanceHeader() {
    Text(
        "$73,589.01",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(48.dp)
    )
}

@Composable
private fun BalanceChangeSubtitle() {
    Text(
        "+412.35 today",
        color = Green,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier
            .paddingFromBaseline(16.dp)
    )
}

@Composable
private fun HomeScreenTabRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(64.dp)
    ) {
        HomeScreenTab(buttonText = "ACCOUNT", isEnabled = true)
        HomeScreenTab(buttonText = "WATCHLIST", isEnabled = false)
        HomeScreenTab(buttonText = "PROFILE", isEnabled = false)
    }
}

@Composable
private fun HomeScreenTab(
    buttonText: String,
    isEnabled: Boolean,
) {
    TextButton(
        onClick = { /*TODO*/ },
        colors = textButtonColors(
            contentColor = White,
            disabledContentColor = White.copy(alpha = ContentAlpha.disabled)
        ),
        enabled = isEnabled,
    ) {
        Text(buttonText)
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
private fun HomeScreenPreview() {
    WeTradeTheme {
        HomeScreen()
    }
}
