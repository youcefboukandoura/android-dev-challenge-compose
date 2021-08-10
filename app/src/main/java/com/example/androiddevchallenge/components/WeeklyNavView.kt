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
fun WeeklyNavView(weekList: List<Week>) {
    LazyRow {
        items(weekList.size) { item ->
            val type = weekList[item].type
            when (type) {
                is WeekType.FutureWeek -> FutureWeekItemView(weekList[item])
                else -> {
                    PastWeekItemView(weekList[item])
                }
            }
        }
    }
}

@Preview
@Composable
fun WeeklyNavViewPreview() {
    MyTheme {
        WeeklyNavView(generateWeekList())
    }
}
