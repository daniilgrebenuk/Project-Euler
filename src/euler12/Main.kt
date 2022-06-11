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
    for (i in 2..sqrt(this.toDouble()).toInt())
        if (this % i == 0L)
            counter++
    return counter * 2
}