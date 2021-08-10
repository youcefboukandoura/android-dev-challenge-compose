package com.example.androiddevchallenge.sample

import com.example.androiddevchallenge.model.Week
import com.example.androiddevchallenge.model.WeekType

fun List<Int>.toWeekList() = this.map { }

fun generateWeekList() = listOf<Week>(
    Week("WED", "04", "AUG", WeekType.PastWeek),
    Week("WED", "11", "AUG", WeekType.FutureWeek),
    Week("WED", "18", "AUG", WeekType.FutureWeek),
    Week("WED", "25", "AUG", WeekType.FutureWeek),
    Week("WED", "01", "SEP", WeekType.FutureWeek),
    Week("WED", "08", "SEP", WeekType.FutureWeek),
    Week("WED", "15", "SEP", WeekType.FutureWeek),
    Week("WED", "22", "SEP", WeekType.FutureWeek),
    Week("WED", "29", "SEP", WeekType.FutureWeek),
    Week("WED", "06", "OCT", WeekType.FutureWeek))