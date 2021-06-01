package com.example.androiddevchallenge.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.model.Recipe
import com.example.androiddevchallenge.model.RecipesDataGenerator
import com.example.androiddevchallenge.ui.theme.DarkGray
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * Main task screen composable
 */
@Composable
fun RecipesListScreen(viewModel: MainViewModel) {
    Column {


        println("recipe list ${viewModel.recipes.size}")
        if (viewModel.recipes.isEmpty()) {
            EmptyView(Modifier.weight(1f))
        } else {
            RecipeListView(
                viewModel.recipes,
                onRecipeClick = { recipeIndex ->
                    viewModel.onRecipeClick(recipeIndex)
                },
                onDeleteRecipeClick = { recipeIndex ->
                    viewModel.onDeleteRecipeClick(recipeIndex)
                },
                onCancelRecipeDeletionClick = { recipeIndex ->
                    viewModel.onCancelDeleteRecipeClick(recipeIndex)
                },
                Modifier.weight(1f)
            )
        }

        BottomView(viewModel)
    }
}

/**
 * Displays list of recipes
 */
@Composable
fun RecipeListView(
    recipeList: List<Recipe>,
    onRecipeClick: (recipeIndex: Int) -> Unit,
    onDeleteRecipeClick: (recipeIndex: Int) -> Unit,
    onCancelRecipeDeletionClick: (recipeIndex: Int) -> Unit,
    modifier: Modifier

) {
    LazyColumn(
        modifier = modifier.background(DarkGray)
    ) {
        items(recipeList.size) { index ->
            // not sure if I should save click property in mode
            val recipe = recipeList[index]
            if (!recipe.clicked) {
                RecipeCard(recipe, onClick = { onRecipeClick(index) })
            } else {
                ConfirmDeletionCard(
                    recipe,
                    onClick = { onDeleteRecipeClick(index) },
                    onCancelRecipeDeletionClick = { onCancelRecipeDeletionClick(index) })
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }
    }
}

/**
 * Draws an "Add" button
 */
@Composable
fun AddButton(onAddRecipeClick: () -> Unit) {
    Button(
        onClick = { onAddRecipeClick() },
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
    ) {
        Text(text = "Add recipe")
    }
}

/**
 * Card which displays a recipe with name, color and price
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit = {}) {
    Card(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .combinedClickable(
                onLongClick = {
                    println("on Long click")
                },
                onClick = {
                    onClick()
                }
            )
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .animateContentSize()
        ) {
            val centerVerticalAlignment = Modifier.align(Alignment.CenterVertically)
            ColorView(color = recipe.color, centerVerticalAlignment)
            RecipeName(
                recipe,
                centerVerticalAlignment
                    .weight(1f)
                    .padding(start = 8.dp)
            )
            VerticalDivider(centerVerticalAlignment)
            RecipePrice(recipe, centerVerticalAlignment)
        }
    }
}

/**
 * Card which shows a request to remove a particular recipe from the list
 */
@Composable
fun ConfirmDeletionCard(
    recipeToDelete: Recipe,
    onClick: () -> Unit = {},
    onCancelRecipeDeletionClick: () -> Unit = {}
) {
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
    ) {

        Column(
            Modifier
                .background(color = recipeToDelete.color)
                .padding(16.dp),
        ) {
            Text(
                text = "Remove from the list?",
                modifier = Modifier.padding(8.dp)
            )
            HorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val weightModifier = Modifier.weight(1f)
                ConfirmationButton(text = "Yes", modifier = weightModifier) {
                    onClick()
                }
                ConfirmationButton(text = "No", modifier = weightModifier) {
                    onCancelRecipeDeletionClick()
                }
            }
        }
    }
}

/**
 * Small color indicator for a recipe
 */
@Composable
fun ColorView(color: Color, modifier: Modifier) {
    Spacer(
        modifier = modifier
            .width(8.dp)
            .height(52.dp)
            .background(color, shape = RoundedCornerShape(6.dp))
    )
}

/**
 * Displays a list of color tags available for filtering. Check [BonusComponentsReview]
 *
 * Use this view for Bonus task
 */
@Composable
fun ColorFilter() {
    Row(
        Modifier
            .background(DarkGray)
            .padding(vertical = 8.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        RecipesDataGenerator.colors.forEach { color ->
            ColorView3(color = color)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ColorView3(color: Color, modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .width(64.dp)
            .height(24.dp)
            .background(color, shape = RoundedCornerShape(12.dp))
    )
}

@Preview
@Composable
fun BonusComponentsReview() {
    MyTheme {
        ColorFilter()
    }
}

@Preview
@Composable
fun ComponentsPreview() {
    MyTheme {
        Surface {
            Column {
                RecipeCard(RecipesDataGenerator.generateRecipe())
                Spacer(modifier = Modifier.size(8.dp))
                ConfirmDeletionCard(RecipesDataGenerator.generateRecipe())
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    MyTheme {
        RecipesListScreen(MainViewModel())
    }
}