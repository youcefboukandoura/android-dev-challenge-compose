/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Recipe
import com.example.androiddevchallenge.model.RecipesDataGenerator

class MainViewModel : ViewModel() {

    var filterColor: Color? = null

    var recipes: List<Recipe> by mutableStateOf(listOf())
        private set

    var filteredRecipes: List<Recipe> by mutableStateOf(recipes)
        private set

    fun onAddRecipe() {
        val createdRecipes = RecipesDataGenerator.generateRecipe()
        recipes = recipes + createdRecipes
        onColorFilterColor()
    }

    fun onRecipeLongClick(index: Int) {
        filteredRecipes = filteredRecipes.toMutableList().also {
            it[index] = it[index].copy(clicked = true)
        }
    }

    fun onDeleteRecipeClick(recipe: Recipe) {
        val findRecipe = recipes.find { it.id == recipe.id }
        recipes = recipes.toMutableList().also {
            it.remove(findRecipe)
        }
        onColorFilterColor()
    }

    fun onCancelDeleteRecipeClick(index: Int) {
        filteredRecipes = filteredRecipes.toMutableList().also {
            it[index] = it[index].copy(clicked = false)
        }
    }

    fun onColorFilterColor(color: Color) {
        filterColor = color
        filteredRecipes = recipes.filter {
            it.color == color
        }
    }

    private fun onColorFilterColor() {
        filteredRecipes = if (filterColor != null) {
            recipes.filter {
                it.color == filterColor
            }
        } else recipes

    }

}
