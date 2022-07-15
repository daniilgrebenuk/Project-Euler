package euler7

import kotlin.math.sqrt

fun main() {
    val primeToFind = 10_001
    var counter = 0

    OUTER@for (i in 2..Long.MAX_VALUE) {
        for (j in 2..sqrt(i.toDouble()).toLong()) {
            if (i % j == 0L)
                continue@OUTER
        }
        counter++
        if (counter == primeToFind) {
            println(i)
            break
        }
    }
}