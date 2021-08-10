package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.androiddevchallenge.model.Week
import com.example.androiddevchallenge.model.WeekType

class MainViewModel {

    val weekList: List<Week> by mutableStateOf(mockedWeeksList)

    var selectedWeek: Week? by mutableStateOf(null)

    fun selectWeek(week: Week) {
        selectedWeek = week
    }
}

val mockedWeeksList = listOf<Week>(
    Week("WED", "04", "AUG", WeekType.PastWeek),
    Week("WED", "11", "AUG", WeekType.FutureWeek),
    Week("WED", "18", "AUG", WeekType.FutureWeek),
    Week("WED", "25", "AUG", WeekType.FutureWeek),
    Week("WED", "01", "SEP", WeekType.FutureWeek),
    Week("WED", "08", "SEP", WeekType.FutureWeek),
    Week("WED", "15", "SEP", WeekType.FutureWeek),
    Week("WED", "22", "SEP", WeekType.FutureWeek),
    Week("WED", "29", "SEP", WeekType.FutureWeek),
    Week("WED", "06", "OCT", WeekType.FutureWeek)
)
