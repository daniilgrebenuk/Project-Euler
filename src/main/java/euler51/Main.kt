package euler51

import kotlin.math.sqrt

private fun main() {
    val primes = getPrimesBelowNumber(1_000_000)

    val groupedPrimes = primes
        .map { prime -> prime to prime.toString().groupingBy { it }.eachCount().maxByOrNull { it.value } }
        .groupBy({ it.second!!.value }, { it.first to it.second!!.key })

    for (numbers in groupedPrimes.values) {
        for ((prime, numberToChange) in numbers) {
            val mutatedNumbers = (0..9)
                .map { prime.toString().replace(numberToChange, it.digitToChar()) }
                .filter { !it.startsWith('0') }

            if (mutatedNumbers.count { primes.contains(it.toInt()) } >= 7) {
                println(mutatedNumbers[0])
                return
            }
        }
    }
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