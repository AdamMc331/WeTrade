package com.adammcneilly.wetrade

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.wetrade.ui.theme.Green
import com.adammcneilly.wetrade.ui.theme.Red
import com.adammcneilly.wetrade.ui.theme.WeTradeTheme

@Composable
fun StockPositionListSheet() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
        ) {
            item {
                Text(
                    "Positions",
                    modifier = Modifier
                        .paddingFromBaseline(
                            top = 40.dp,
                            bottom = 24.dp,
                        ),
                )
            }

            items(stockPositionList) { position ->
                StockPositionListItem(position)

                Divider()
            }
        }
    }
}

@Composable
private fun StockPositionListItem(stockPosition: StockPosition) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PriceAndChangeColumn(
            stockPosition,
            Modifier
                .fillMaxWidth(0.20F),
        )
        NameColumn(
            stockPosition,
            Modifier
                .weight(1F),
        )
        StockChart(
            stockPosition,
            Modifier,
        )
    }
}

@Composable
private fun PriceAndChangeColumn(
    stockPosition: StockPosition,
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            stockPosition.currentPrice,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
        )

        val changeCharacter = stockPosition.change.first()
        val changeColor = if (changeCharacter == '+') {
            Green
        } else {
            Red
        }

        Text(
            stockPosition.change,
            color = changeColor,
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp, bottom = 16.dp)
        )
    }
}

@Composable
private fun NameColumn(
    stockPosition: StockPosition,
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            stockPosition.shortName,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
        )

        Text(
            stockPosition.fullName,
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp, bottom = 16.dp)
        )
    }
}

@Composable
private fun StockChart(
    stockPosition: StockPosition,
    modifier: Modifier,
) {
    Image(
        painterResource(id = stockPosition.chartRes),
        contentDescription = null,
        modifier = modifier,
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
private fun StockPositionListSheetPreview() {
    WeTradeTheme {
        StockPositionListSheet()
    }
}