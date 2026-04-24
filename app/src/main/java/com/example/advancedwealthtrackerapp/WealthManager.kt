package com.example.advancedwealthtracker

class WealthManager(
    private val firstName: String,
    private val lastName: String,
    private val birthDay: Int
) {
    val k: Double = (firstName.length + lastName.length).toDouble() / birthDay

    fun calculateFinalSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * k
    }
}