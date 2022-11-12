package euler72

import kotlin.math.round
import kotlin.math.sqrt

val primes = getPrimesBelowNumber(1_000_000)

fun main() {
    val start = System.currentTimeMillis()
    var res = 0L

    (2..1_000_000)
        .associateWith {
            if (it in primes)
                listOf(it)
            else {
                it.findDivisors()
            }
        }
        .forEach { (number, list) ->
            res += round(number * list.map { 1 - 1 / it.toDouble() }.reduce { d1, d2 -> d1 * d2 }).toInt()
        }
    println(res)
    println(System.currentTimeMillis() - start)
}

private fun Int.findDivisors(): List<Int> {
    val resList = ArrayList<Int>()
    var n = this
    var currentSqrt = sqrt(n.toDouble())
    for (prime in primes) {
        if (prime > currentSqrt)
            break
        if (n % prime == 0) {
            while (n % prime == 0) {
                n /= prime
            }
            resList += prime
            currentSqrt = sqrt(n.toDouble())
        }
    }
    if (n != 1) {
        resList += n
    }
    return resList
}

private fun getPrimesBelowNumber(number: Int): Set<Int> {
    val primes = LinkedHashSet<Int>()
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