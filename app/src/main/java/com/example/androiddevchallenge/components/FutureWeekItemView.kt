package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Week
import com.example.androiddevchallenge.model.WeekType
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.primary200
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun FutureWeekItemView(week: Week, onClick: (week: Week) -> Unit, selectedWeek: Week?) {
    val backgroundColor = if (week == selectedWeek) Color.Transparent else primary200
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(90.dp)
            .padding(8.dp)
            .background(backgroundColor)
            .border(0.dp, Color.Transparent, shape = shapes.medium)
            .clickable { onClick(week) },

        contentAlignment = Alignment.Center
    ) {
        Column {
            Spacer(modifier = Modifier.weight(1f))
            Text(

                text = week.weekDay.toString(),
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Text(
                text = week.day,
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Text(
                text = week.month,
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun FutureWeekItemViewPreview() {
    MyTheme {
        FutureWeekItemView(
            week = Week("SAT", "1", "JUL", WeekType.FutureWeek),
            onClick = {},
            selectedWeek = null
        )
    }
}
