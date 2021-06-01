package com.example.androiddevchallenge.model

import androidx.compose.ui.graphics.Color
import java.util.*

data class Recipe(
    val id: Int = UUID.randomUUID().hashCode(),
    val name: String,
    // cents
    val price: Double,
    val color: Color,
    var clicked: Boolean = false
) {

}