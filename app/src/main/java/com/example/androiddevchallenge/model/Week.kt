package com.example.androiddevchallenge.model

data class Week(
    val weekDay: String,
    val day: String,
    val month: String,
    val type: WeekType
)

sealed class WeekType {
    object PastWeek : WeekType()
    object FutureWeek : WeekType()
}
