package euler37

import kotlin.math.sqrt

fun main() {
    val primes = getPrimesBelowNumber(1_000_000)

    fun Int.isInterestingPrime(): Boolean {
        if (this < 10)
            return false

        val primeString = this.toString()
        for (i in 1 until primeString.length) {
            if (!(primes.contains(primeString.substring(i).toInt()) &&
                        primes.contains(primeString.substring(0, primeString.length - i).toInt()))
            ) return false
        }
        return true
    }

    var sum = 0
    for (prime in primes) {
        if (prime.isInterestingPrime())
            sum += prime
    }
    println(sum)
}


private fun getPrimesBelowNumber(number: Int): Set<Int> {
    val primes = HashSet<Int>()
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