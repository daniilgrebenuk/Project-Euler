package euler3

import kotlin.math.sqrt


fun main() {
    var num = 600851475143
    var lastFactor = 2L

    while (num % 2 == 0L) {
        num /= 2
    }
    if (num != 1L)
        lastFactor = 3L

    var factor = 3L
    var threshold = sqrt(num.toDouble()).toLong()
    while (num > 1 && factor < threshold) {
        if (num % factor == 0L) {
            lastFactor = factor
            while (num % factor == 0L)
                num /= factor
            threshold = sqrt(num.toDouble()).toLong()
        }
        factor++
    }

    println(if (num == 1L) lastFactor else num)
}