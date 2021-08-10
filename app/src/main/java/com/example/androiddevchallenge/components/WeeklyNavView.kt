package com.example.androiddevchallenge.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Week
import com.example.androiddevchallenge.model.WeekType
import com.example.androiddevchallenge.sample.generateWeekList
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * Main task screen composable
 */
@Composable
fun WeeklyNavView(weekList: List<Week>, onClick: (week: Week) -> Unit = {}, selectedWeek: Week?) {
    LazyRow {
        items(weekList.size) { item ->
            when (weekList[item].type) {
                is WeekType.FutureWeek -> FutureWeekItemView(weekList[item], onClick, selectedWeek)
                else -> {
                    PastWeekItemView(weekList[item], onClick, selectedWeek)
                }
            }
        }
    }
}

@Preview
@Composable
fun WeeklyNavViewPreview() {
    MyTheme {
        WeeklyNavView(generateWeekList(), selectedWeek = null)
    }
}
