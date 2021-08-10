package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

/**
 * Main task screen composable
 */
@Composable
fun FutureWeekItemView(item: Week) {

    println(item)
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(90.dp)
            .padding(8.dp)
            .background(primary200)
            .border(0.dp, Color.Transparent, shape = RoundedCornerShape(8.dp)),

        contentAlignment = Alignment.Center
    ) {
        Column {
            Spacer(modifier = Modifier.weight(1f))
            Text(

                text = item.weekDay.toString(),
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Text(
                text = item.day,
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Text(
                text = item.month,
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
        FutureWeekItemView(item = Week("SAT", "1", "JUL", WeekType.FutureWeek(false)))
    }
}
