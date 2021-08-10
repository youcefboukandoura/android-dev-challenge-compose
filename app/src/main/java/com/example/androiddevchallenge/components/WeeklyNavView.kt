package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            val week = weekList[item]
            Box(
                Modifier
                    .width(94.dp)
                    .height(94.dp)
                    .background(Color.White)
            ) {
                when (week.type) {
                    is WeekType.FutureWeek -> FutureWeekItemView(
                        weekList[item],
                        onClick,
                        selectedWeek
                    )
                    else -> PastWeekItemView(weekList[item], onClick, selectedWeek)
                }

                if (week == selectedWeek) {
                    SelectedWeekItemView()
                }
            }
            Divider(color = Color.Black, thickness = 2.dp)
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
