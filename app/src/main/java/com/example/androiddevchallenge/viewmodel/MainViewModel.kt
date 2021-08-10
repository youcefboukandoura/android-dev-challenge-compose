package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.androiddevchallenge.model.Week

class MainViewModel {

    val weekList: List<Week> by mutableStateOf(listOf(Week("SAT", "1", "JUL")))

    var selectedWeek: Week? by mutableStateOf(null)

    fun selectWeek(week: Week) {
        selectedWeek = week
    }
}
