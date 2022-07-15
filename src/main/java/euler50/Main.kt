package euler50

import kotlin.math.sqrt

fun main() {
    val primes = getPrimesBelowNumber(1_000_000)
    val listOfPrimes = primes.toIntArray()
    var ans = 0
    OUTER@ for (amountOfPrimes in 21..1500) {
        for (primeIndex in 0 until listOfPrimes.size - amountOfPrimes) {
            var sum = 0L
            repeat(amountOfPrimes) {
                sum += listOfPrimes[primeIndex + it]
            }
            if (sum < 1_000_000) {
                if (primes.contains(sum.toInt())) {
                    ans = sum.toInt()
                    break
                }
            } else if (primeIndex == 0) {
                break@OUTER
            } else {
                break
            }
        }
    }

    println(ans)
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