package com.example.androiddevchallenge.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Week
import com.example.androiddevchallenge.model.WeekType
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes

/**
 * Main task screen composable
 */
@Composable
fun PastWeekItemView(week: Week, onClick: (week: Week) -> Unit, selectedWeek: Week?) {
    if (week == selectedWeek) {
        SelectedWeekItemView(week = week)
    } else {
        val stroke = Stroke(
            width = 2f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
        Box(
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
                .padding(8.dp)
                .border(0.dp, Color.Transparent, shape = shapes.medium)
                .clickable { onClick(week) },

            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                drawRoundRect(
                    color = Color.Gray,
                    style = stroke,
                    cornerRadius = CornerRadius(8f, 8f)
                )
            }
            Column {
                Spacer(modifier = Modifier.weight(1f))
                Text(

                    text = week.weekDay,
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
}

@Preview
@Composable
fun PastWeekItemViewPreview() {
    MyTheme {
        PastWeekItemView(
            week = Week("SAT", "1", "JUL", WeekType.PastWeek),
            onClick = {},
            selectedWeek = null
        )
    }
}
