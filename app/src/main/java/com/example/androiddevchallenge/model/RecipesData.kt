package com.example.androiddevchallenge.model

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.theme.Red300
import com.example.androiddevchallenge.ui.theme.Yellow800
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.teal200
import kotlin.random.Random

object RecipesData {

    fun generateRecipes(number: Int): MutableList<Recipe> {
        val list = mutableListOf<Recipe>()
        for (i in 0..number) {
            list += Recipe(name = names.random(), price = randomPrice, color = randomColor)
        }
        return list
    }

    val randomPrice: Double
        get() = ((Random.nextInt(500, 2000) / 5) * 5).toDouble()

    val colors = listOf(purple200, teal200, Yellow800, Red300)
    val randomColor: Color
        get() = colors.random()


    val names = listOf(
        "Moroccan Skirt Steak",
        "Crispy Fish Goujons",
        "Simple Sumptuous Sea Bream",
        "Mozzarella and Pesto Roulades",
        "Mexican Tortilla Stack",
        "Roasted Rosemary Butternut Squash",
        "Gnocchi Allo Genovese",
        "Sausage Risotto",
        "Genki Yakitori with Crispy Red Onions",
        "Bacon Wrapped Pork Loin",
        "Chicken Sausage Cavatappi Bolognese",
        "Pesto Caprese Sandwiches",
        "Prosciutto Caprese Sandwiches",
        "Four Cheese Pizza",
        "Pork Sausage & Pepper Pizza",
        "Sesame Salad & Fully Cooked Chicken",
        "Spinach & Feta Egg Bites",
        "Annie’s Organic Cinnamon Rolls",
        "Garlic Bread",
        "New England Clam Chowder",
        "Garlic Bread & Crunchy Sesame Salad Combo",
        "Cheesecake Variety Pack",
        "Vanilla Delight Cheesecakes & Lava Cakes",
        "Pillsbury™ Cookie Dough with OREO® Cookie Pieces",
        "Salted Caramel Mascarpone Cheesecake",
        "Atlantic Salmon Fillets",
        "Curry-Spiced Chickpea Bowls",
        "Cavatappi Beef Ragù",
    )
}