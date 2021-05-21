package com.example.androiddevchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Recipe
import com.example.androiddevchallenge.model.RecipesData
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple200

@Composable
fun RecipesListScreen() {
    LazyColumn {
        items(20) {
            RecipeCard()
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }
    }
}

@Composable
fun RecipeCard() {
    Card(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        val recipe = Recipe(
            name = RecipesData.names.random(),
            price = RecipesData.randomPrice,
            color = RecipesData.randomColor
        )
        Row(Modifier.padding(8.dp)) {
            val centerVerticalAlignment = Modifier.align(Alignment.CenterVertically)
            ColorView(color = recipe.color, centerVerticalAlignment)
            RecipeName(recipe, centerVerticalAlignment.weight(1f))
            VerticalDivider(centerVerticalAlignment)
            RecipePrice(recipe, centerVerticalAlignment)
        }
    }
}

@Composable
fun RecipePrice(
    recipe: Recipe,
    modifier: Modifier
) {
    Text(
        text = String.format("$ %.2f", recipe.price / 100),
        modifier = modifier
            .padding(start = 8.dp)
            .width(52.dp),
        style = TextStyle.Default.copy(fontStyle = FontStyle.Italic)
    )
}

@Composable
fun RecipeName(
    recipe: Recipe,
    modifier: Modifier
) {
    Text(
        text = recipe.name,
        modifier.padding(start = 8.dp, end = 8.dp)
    )
}

@Composable
fun VerticalDivider(modifier: Modifier) {
    Spacer(
        modifier = modifier
            .width(1.dp)
            .height(32.dp)
            .background(Color.DarkGray)
    )
}

@Composable
fun ColorView(color: Color, modifier: Modifier) {
    Spacer(
        modifier = modifier
            .size(40.dp)
            .background(color, shape = RoundedCornerShape(6.dp))
    )
}


@Preview
@Composable
fun ColorViewPreview() {
    MyTheme {
        RecipesListScreen()
    }
}