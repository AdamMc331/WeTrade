package com.adammcneilly.wetrade

data class StockPosition(
    val currentPrice: String,
    val change: String,
    val shortName: String,
    val fullName: String,
    val chartRes: Int,
)

val stockPositionList = listOf(
    StockPosition(
        currentPrice = "$7,918",
        change = "-0.54%",
        shortName = "ALK",
        fullName = "Alaska Air Group, Inc.",
        chartRes = R.drawable.ic_home_alk,
    ),
    StockPosition(
        currentPrice = "$1,293",
        change = "+4.18%",
        shortName = "BA",
        fullName = "Boeing Co.",
        chartRes = R.drawable.ic_home_ba,
    ),
    StockPosition(
        currentPrice = "$893.50",
        change = "-0.54%",
        shortName = "DAL",
        fullName = "Delta Airlines Inc.",
        chartRes = R.drawable.ic_home_dal,
    ),
    StockPosition(
        currentPrice = "$12,301",
        change = "+2.51%",
        shortName = "EXPE",
        fullName = "Expedia Group Inc.",
        chartRes = R.drawable.ic_home_exp,
    ),
    StockPosition(
        currentPrice = "$12,301",
        change = "+1.38%",
        shortName = "EADSY",
        fullName = "Airbus SE",
        chartRes = R.drawable.ic_home_eadsy,
    ),
    StockPosition(
        currentPrice = "$8,521",
        change = "+1.56%",
        shortName = "JBLU",
        fullName = "Jetblue Airways Corp.",
        chartRes = R.drawable.ic_home_jblu,
    ),
    StockPosition(
        currentPrice = "$521",
        change = "+2.75%",
        shortName = "MAR",
        fullName = "Marriott Internation Inc.",
        chartRes = R.drawable.ic_home_mar,
    ),
    StockPosition(
        currentPrice = "$5,481",
        change = "+0.14%",
        shortName = "CCL",
        fullName = "Carnival Corp",
        chartRes = R.drawable.ic_home_ccl,
    ),
    StockPosition(
        currentPrice = "$9,184",
        change = "+1.69%",
        shortName = "RCL",
        fullName = "Royal Caribbean Cruises",
        chartRes = R.drawable.ic_home_rcl,
    ),
    StockPosition(
        currentPrice = "$654",
        change = "+3.23%",
        shortName = "TRVL",
        fullName = "Travelocity Inc.",
        chartRes = R.drawable.ic_home_trvl,
    ),
)