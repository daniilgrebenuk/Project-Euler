package euler5

import kotlin.math.floor
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val primes = ArrayList<Long>()
    val k = 20L

    OUTER@ for (i in 2..k) {
        for (j in 2..sqrt(i.toDouble()).toLong()) {
            if (i % j == 0L)
                continue@OUTER
        }
        primes.add(i)
    }

    var result = 1L
    val sqrtOfK = sqrt(k.toDouble())
    for (prime in primes) {
        result *=
            if (prime > sqrtOfK)
                prime
            else
                prime.toDouble()
                    .pow(
                        floor(
                            log(
                                k.toDouble(),
                                prime.toDouble()
                            )
                        )
                    ).toLong()
    }

    println(result)
}
