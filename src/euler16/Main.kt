package euler16

import java.math.BigInteger

fun main() {
    val power = 1000

    println(
        BigInteger.valueOf(2L).pow(power)
            .toString()
            .chars()
            .map { it - 48 }
            .sum()
    )
}