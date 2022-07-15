package euler29

import java.math.BigInteger

fun main() {
    val numbers = HashSet<BigInteger>()
    for (a in 2..100L) {
        for (b in 2..100) {
            numbers.add(BigInteger.valueOf(a).pow(b))
        }
    }
    println(numbers.size)
}