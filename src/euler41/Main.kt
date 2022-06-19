package euler41

import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    val primes = getPrimesBelowNumber(10_000_000)
    var res = 0
    for (prime in primes) {
        if (prime.isPandigital())
            res = max(res, prime)
    }

    println(res)
}

fun Int.isPandigital(): Boolean {
    val tempString = this.toString()

    if (tempString.contains("0"))
        return false

    if (tempString.chars().distinct().count().toInt() != tempString.length)
        return false

    for (number in 1..tempString.length) {
        if (!tempString.contains(number.toString()))
            return false
    }

    return true
}

fun getPrimesBelowNumber(number: Int): List<Int> {
    val primes = ArrayList<Int>()
    val booleanArray = BooleanArray(number) { true }
    booleanArray[0] = false
    booleanArray[1] = false
    for (i in 2..sqrt(number.toDouble()).toInt()) {
        if (!booleanArray[i])
            continue
        for (j in i * i until number step i) {
            booleanArray[j] = false
        }
    }
    booleanArray.forEachIndexed { index, b -> if (b) primes += index }
    return primes
}