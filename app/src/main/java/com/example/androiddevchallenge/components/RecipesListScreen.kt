package com.example.androiddevchallenge.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.DismissDirection.EndToStart
import androidx.compose.material.DismissDirection.StartToEnd
import androidx.compose.material.DismissValue.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
        ColorFilter(
            viewModel.filterColor,
            viewModel.recipes
        ) { color -> viewModel.onColorFilterColor(color) }
        if (viewModel.filteredRecipes.isEmpty()) {
            EmptyView(Modifier.weight(1f))
        } else {
            RecipeListView(
                viewModel.filteredRecipes,
                onRecipeLongClick = { recipeIndex ->
                    viewModel.onRecipeLongClick(recipeIndex)
                },
                onDeleteRecipeClick = { recipe ->
                    viewModel.onDeleteRecipeClick(recipe)
                },
                onCancelRecipeDeletionClick = { recipeIndex ->
                    viewModel.onCancelDeleteRecipeClick(recipeIndex)
                },
                Modifier.weight(1f)
            )
        }

        BottomView(viewModel.recipes) { viewModel.onAddRecipe() }
    }
}

/**
 * Displays list of recipes
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecipeListView(
    recipeList: List<Recipe>,
    onRecipeLongClick: (recipeIndex: Int) -> Unit,
    onDeleteRecipeClick: (recipeIndex: Recipe) -> Unit,
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
                RecipeCard(recipe, onDeleteClick = { onRecipeLongClick(index) })
            } else {
                ConfirmDeletionCard(
                    recipe,
                    onClick = { onDeleteRecipeClick(recipe) },
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
@ExperimentalMaterialApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeCard(recipe: Recipe, onDeleteClick: () -> Unit = {}) {
    var dismissed by remember { mutableStateOf(false) }
    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it == DismissedToEnd) {
                dismissed = !dismissed
            }
            if (it == DismissedToStart) {
                onDeleteClick()
            }
            it != DismissedToEnd
        }
    )
    SwipeToDismiss(
        state = dismissState,
        modifier = Modifier.padding(vertical = 4.dp),
        directions = setOf(EndToStart),
        dismissThresholds = { direction ->
            FractionalThreshold(if (direction == EndToStart) 0.25f else 0.5f)
        },
        background = {
            val direction = dismissState.dismissDirection ?: return@SwipeToDismiss
            val color by animateColorAsState(
                when (dismissState.targetValue) {
                    Default -> Color.LightGray
                    DismissedToEnd -> Color.Green
                    DismissedToStart -> recipe.color
                }
            )
            val alignment = when (direction) {
                StartToEnd -> Alignment.CenterStart
                EndToStart -> Alignment.CenterEnd
            }

            Box(
                Modifier
                    .fillMaxSize()
                    .background(color)
                    .padding(horizontal = 20.dp),
                contentAlignment = alignment
            ) {}
        },
        dismissContent = {
            Card(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .combinedClickable(
                        onLongClick = { onDeleteClick() },
                        onClick = {}
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
    )
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
fun ColorFilter(
    selectedColor: Color = Color.Transparent,
    recipes: List<Recipe>,
    onClick: (color: Color) -> Unit = {}
) {
    Row(
        Modifier
            .background(DarkGray)
            .padding(vertical = 8.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        RecipesDataGenerator.colors.forEach { color ->
            val borderColor = if (selectedColor == color) Color.White else Color.Transparent
            Text(
                text = "${recipes.filter { it.color == color }.size} / ${recipes.size}",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .border(3.dp, borderColor, shape = RoundedCornerShape(12.dp))
                    .clickable { onClick(color) }
                    .width(64.dp)
                    .height(24.dp)
                    .background(color, shape = RoundedCornerShape(12.dp)),
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@Preview
@Composable
fun BonusComponentsReview() {
    MyTheme {
        ColorFilter(Color.Transparent, arrayListOf())
    }
}

@OptIn(ExperimentalMaterialApi::class)
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