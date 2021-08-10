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
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Week
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * Main task screen composable
 */
@Composable
fun PastWeekItemView(item: Week) {
    Box(
        modifier = Modifier
            .background(DarkGray)
            .width(90.dp)
            .height(64.dp)
            .padding(0.dp, 4.dp)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp)),

        contentAlignment = Alignment.Center
    ) {
        Column {
            Spacer(modifier = Modifier.weight(1f))
            Text(

                text = item.weekDay,
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
        }
    }
}

@Preview
@Composable
fun PastWeekItemViewPreview() {
    MyTheme {
        PastWeekItemView(item = Week("SAT", "1", "JUL"))
    }
}
