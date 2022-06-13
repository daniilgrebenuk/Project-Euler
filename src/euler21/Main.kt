package euler21

import kotlin.math.sqrt

fun main() {
    var sum = 0
    for (number in 1 until 10_000) {
        if (hasFriendNumber(number))
            sum += number
    }
    println(sum)
}

fun hasFriendNumber(number: Int): Boolean {
    val friendNumber = getSumOfDivisors(number)
    if (friendNumber == number) return false
    return number == getSumOfDivisors(friendNumber)
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