package euler46

import java.util.*
import kotlin.math.sqrt

fun main() {
    val primes = getPrimesBelowNumber(100_000)
    val numbersForCheck = TreeSet<Int>()
    for (divisor in 3..10_000 step 2) {
        for (number in divisor * 3..100_000 step divisor * 2) {
            numbersForCheck.add(number)

        }
    }


    OUTER@for (numberForCheck in numbersForCheck) {

        for (prime in primes) {
            if (numberForCheck < prime) {
                break
            }

            if (((numberForCheck - prime) / 2).isSquare()){
                continue@OUTER
            }
        }
        println(numberForCheck)
        break
    }
}

private fun Int.isSquare(): Boolean {
    val sqrt = sqrt(this.toDouble()).toInt();
    return sqrt * sqrt == this
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