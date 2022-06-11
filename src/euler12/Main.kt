package euler12

import kotlin.math.sqrt

fun main() {
    var nextNumber = 0L
    for (i in 1L..100000) {
        nextNumber += i
        if (nextNumber.getDivisorsCount() > 500) {
            println(nextNumber)
            break
        }
    }
}

fun Long.getDivisorsCount(): Int {
    var counter = 1
    val sqrtOfNumber = sqrt(this.toDouble()).toLong()
    for (i in 2..sqrtOfNumber)
        if (this % i == 0L)
            counter++

    return if(sqrtOfNumber * sqrtOfNumber == this) counter * 2 - 1 else counter * 2
}