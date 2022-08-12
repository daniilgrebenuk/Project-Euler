package euler69

import java.util.*
import kotlin.math.sqrt

fun main() {
    val primes = getPrimesBelowNumber(30)
    var last = 1
    var current = 1
    for (prime in primes) {
        current *= prime
        if (current > 1_000_000){
            println(last)
            break
        }
        last = current
    }
}

private fun getPrimesBelowNumber(number: Int): List<Int> {
    val primes = LinkedList<Int>()
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