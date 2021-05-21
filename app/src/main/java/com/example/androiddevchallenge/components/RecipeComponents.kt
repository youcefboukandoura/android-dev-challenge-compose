package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Recipe
import com.example.androiddevchallenge.ui.theme.DarkGray


@Composable
fun EmptyView(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No recipes added",
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h5
        )
    }
}

@Composable
fun RecipeName(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    Text(
        text = recipe.name,
        modifier.padding(start = 8.dp, end = 8.dp)
    )
}

@Composable
fun RecipePrice(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    Text(
        text = String.format("$ %.2f", recipe.price / 100),
        modifier = modifier
            .padding(start = 8.dp)
            .width(52.dp),
        style = MaterialTheme.typography.subtitle2.copy(fontStyle = FontStyle.Italic)
    )
}

@Composable
fun VerticalDivider(modifier: Modifier) {
    Spacer(
        modifier = modifier
            .width(1.dp)
            .height(42.dp)
            .background(Color.DarkGray)
    )
}