package com.example.androiddevchallenge.sample

import com.example.androiddevchallenge.model.Week

fun List<Int>.toWeekList() = this.map { }

fun generateWeekList() = listOf(
    Week("WED", "04", "AUG"),
    Week("WED", "11", "AUG"),
    Week("WED", "18", "AUG"),
    Week("WED", "25", "AUG"),
    Week("WED", "01", "SEP"),
    Week("WED", "08", "SEP"),
    Week("WED", "15", "SEP"),
    Week("WED", "22", "SEP"),
    Week("WED", "29", "SEP"),
    Week("WED", "06", "OCT")
)
