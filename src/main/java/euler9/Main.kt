package euler9

import kotlin.math.pow

fun main() {
    val s = 1000L

    for (a in 3..s / 3) {
        for (b in a..s / 2) {
            if (a * a + b * b == (s - a - b).toDouble().pow(2).toLong()) {
                println(a * b * (s - a - b))
                return
            }
        }
    }
}