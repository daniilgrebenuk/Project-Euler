package euler49

import kotlin.math.sqrt

fun main() {
    val primes = getPrimesWithFourNumber()
    for (i in 1..4500) {
        for (prime in primes) {
            if (primes.contains(prime + i) && primes.contains(prime + 2 * i) && arePermutation(prime, prime + i, prime + 2 * i)) {
                if (prime != 1487) {
                    println("$prime${prime + i}${prime + 2 * i}")
                    return
                }
            }
        }
    }
}

private fun arePermutation(vararg arr: Int): Boolean =
        arr.map { String(it.toString().toCharArray().sortedArray()) }.distinct().size == 1

private fun getPrimesWithFourNumber(): Set<Int> {
    val number = 10000
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
    booleanArray.forEachIndexed { index, b -> if (b && index >= 1000) primes += index }
    return primes
}