package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun SelectedWeekItemView() {

    Box(
        modifier = Modifier
            .width(94.dp)
            .height(94.dp)
            .padding(4.dp)
            .background(Color.Transparent)
            .border(1.dp, Color.Black, shapes.small),
        contentAlignment = Alignment.Center
    ) {
    }
}

@Preview
@Composable
fun SelectedWeekViewPreview() {
    MyTheme {
        SelectedWeekItemView()
    }
}
