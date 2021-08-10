package com.example.androiddevchallenge.model

data class Week(
    val weekDay: String,
    val day: String,
    val month: String,
    val type: WeekType
)

sealed class WeekType(open val isSelected: Boolean) {
    data class PastWeek(override val isSelected: Boolean) : WeekType(isSelected)
    data class FutureWeek(override val isSelected: Boolean) : WeekType(isSelected)
}
