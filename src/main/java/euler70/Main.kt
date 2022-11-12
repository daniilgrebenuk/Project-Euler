package euler70

import kotlin.math.sqrt

fun main() {
    val start = System.currentTimeMillis()
    val primes = getPrimesBelowNumber(4_000)

    val numbers = ArrayList<Pair<Int, List<Int>>>()


    outer@ for (i in primes.indices) {
        for (j in (i + 1) until primes.size) {
            val temp = primes[i] * primes[j]
            if (temp < 10_000_000)
                numbers += temp to listOf(primes[i], primes[j])
            else
                continue@outer
        }
    }
    var lowest = 0 to 1.1
    for (i in numbers) {
        val resultFi = fiFunction(i)
        val temp = i.first.toDouble() / resultFi
        if (isPermutation(i.first, resultFi) && temp < lowest.second) {
            lowest = i.first to temp
        }
    }
    println(lowest.first)
    println("Time: ${System.currentTimeMillis() - start}")
}

private fun isPermutation(firstNumber: Int, secondNumber: Int) =
    firstNumber.toString().toCharArray().sorted() == secondNumber.toString().toCharArray().sorted()

private fun fiFunction(number: Pair<Int, List<Int>>): Int {
    return number.first + 1 - number.second.sum()
}

private fun getPrimesBelowNumber(number: Int): List<Int> {
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