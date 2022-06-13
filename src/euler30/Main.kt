package euler30

import kotlin.math.pow

fun main() {
    val power = 5

    var counter = 1
    while ((9.0).pow(power) * counter >= "9".repeat(counter).toDouble())
        counter++

    val maxNumber = "9".repeat(counter).toInt()
    var result = 0
    for (i in 2..maxNumber) {
        if (getSumOfPower(i, power) == i)
            result += i
    }
    println(result)
}

fun getSumOfPower(number: Int, power: Int): Int {
    return number.toString().chars().map { (it - 48).toDouble().pow(power).toInt() }.sum()
}