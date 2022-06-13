package euler27

import kotlin.math.sqrt

fun main() {
    val primes = HashSet<Int>()
    val threshold = 1_000_000
    val booleanArray = BooleanArray(threshold) { true }
    booleanArray[0] = false
    booleanArray[1] = false
    for (i in 2..sqrt(threshold.toDouble()).toInt()) {
        if (!booleanArray[i])
            continue
        for (j in i * i until threshold step i) {
            booleanArray[j] = false
        }
    }
    booleanArray.forEachIndexed { index, b -> if (b) primes += index }

    fun getLengthOfFormulas(a: Int, b: Int): Int {
        var counter = 0
        while (primes.contains(counter * counter + a * counter + b))
            counter++
        return counter
    }
    var resultMultiplication = 0
    var maxLength = 0

    for (a in -999..999) {
        for (b in -1000..1000) {
            val temp = getLengthOfFormulas(a, b)
            if (temp > maxLength) {
                maxLength = temp
                resultMultiplication = a * b
            }
        }
    }

    println(resultMultiplication)
}

