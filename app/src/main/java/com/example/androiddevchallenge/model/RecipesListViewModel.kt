package com.example.androiddevchallenge.model

class RecipesListViewModel {

    // getting data to display on the UI from the data source
    val recipesList = RecipesDataGenerator.generateRecipes(10)
}