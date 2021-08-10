package com.example.androiddevchallenge.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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

@Composable
fun SelectedWeekItemView(week: Week) {

    val stroke = Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(90.dp)
            .background(Color.Black)
            .padding(8.dp),

        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            drawRoundRect(color = Color.Gray, style = stroke, cornerRadius = CornerRadius(8f, 8f))
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

@Preview
@Composable
fun SelectedWeekViewPreview() {
    MyTheme {
        PastWeekItemView(
            week = Week("SAT", "1", "JUL", WeekType.PastWeek),
            onClick = {},
            selectedWeek = null
        )
    }
}
