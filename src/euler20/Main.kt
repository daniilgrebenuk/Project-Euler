package euler20

import java.math.BigInteger
import java.util.stream.IntStream

fun main() {
    println(
        IntStream.range(1, 100)
            .mapToObj { BigInteger.valueOf(it.toLong()) }
            .reduce { b1, b2 -> b1.multiply( b2) }
            .get()
            .toString()
            .chars()
            .map { it - 48 }
            .sum()
    )
}