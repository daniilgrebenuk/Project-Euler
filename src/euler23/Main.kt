package euler23

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashSet
import kotlin.math.sqrt

fun main() {
    val abundantNumbers = ArrayList<Int>()

    for (number in 1..28123) {
        if (getSumOfDivisors(number) > number)
            abundantNumbers += number
    }

    val notCorrectNumbers = LinkedHashSet<Int>()

    for (i in abundantNumbers.indices) {
        val firstNumber = abundantNumbers[i]
        if (firstNumber * 2 > 28123)
            break
        for (j in i until abundantNumbers.size) {
            val secondNumber = abundantNumbers[j]
            if (firstNumber + secondNumber > 28123)
                break
            notCorrectNumbers += (firstNumber + secondNumber)
        }
    }
    val toCheck = LinkedList(notCorrectNumbers.sorted())

    var sum = 0
    for (number in 1..28123) {
        if (number == toCheck.first) {
            toCheck.removeFirst()
        }else {
            sum += number
        }
    }

    println(sum)
}


fun getSumOfDivisors(number: Int): Int {
    if (number in 0..1)
        return 0

    var sum = 1

    val sqrtOfNumber = sqrt(number.toDouble()).toInt()
    for (divisor in 2..sqrtOfNumber) {
        if (number % divisor == 0) {
            sum += divisor
            sum += number / divisor
        }
    }

    if (sqrtOfNumber * sqrtOfNumber == number)
        sum -= sqrtOfNumber

    return sum
}