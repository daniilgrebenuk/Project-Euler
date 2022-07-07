package euler35

import kotlin.math.sqrt

fun main() {
    val threshold = 1_000_000
    val primes = getPrimesBelowNumber(threshold)

    fun isCircularPrime(number: Int): Boolean{
        var numberToRotate = number.rotateNumber().toInt()

        while (numberToRotate != number) {
            if (!primes.contains(numberToRotate))
                return false
            numberToRotate = numberToRotate.rotateNumber()
        }

        return true
    }
    var counter = 0
    for (prime in primes) {
        if (isCircularPrime(prime))
            counter++
    }
    println(counter)
}

private fun Int.rotateNumber(): Int {
    val str = this.toString()
    return (str.last() + str.substring(0, str.length - 1)).toInt()
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