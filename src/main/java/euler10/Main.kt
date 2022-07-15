package euler10

import kotlin.math.sqrt

fun main() {
    var sum = 0L

    OUTER@for(i in 2..2_000_000) {
        for (j in 2..sqrt(i.toDouble()).toInt()) {
            if (i % j == 0) {
                continue@OUTER
            }
        }
        sum += i
    }
    println(sum)
}