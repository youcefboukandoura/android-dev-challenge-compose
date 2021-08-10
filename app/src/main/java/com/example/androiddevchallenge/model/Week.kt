package com.example.androiddevchallenge.model

data class Week(
    val weekDay: String,
    val day: String,
    val month: String,
    val type: WeekType
)

sealed class WeekType() {
    data class PastWeek(val isSelected: Boolean) : WeekType()
    data class FutureWeek(val isSelected: Boolean) : WeekType()
}
