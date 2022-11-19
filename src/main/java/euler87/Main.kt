package euler87

import java.util.TreeSet
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val limit = 50_000_000
    val primes = getPrimesBelowNumber(sqrt(51_000_000.0).toInt())
    val squares = primes.map { it.powWithLimit(2, limit) }.filter { it < limit }
    val cubes = primes.map { it.powWithLimit(3, limit) }.filter { it < limit }
    val fourthPowers = primes.map { it.powWithLimit(4, limit) }.filter { it < limit }

    val res = HashSet<Int>()
    for (s in squares) {
        for (c in cubes) {
            for (f in fourthPowers) {
                (s + c + f).also {
                    if (it < limit) res += it
                }
            }
        }
    }
    println(res.size)
}

private fun Int.powWithLimit(power:Int, limit: Int): Int {
    val temp = this.toBigInteger().pow(power).let {
        if (it < limit.toBigInteger())
            it.toInt()
        else
            limit + 1
    }
    return temp
}

private fun getPrimesBelowNumber(number: Int): Set<Int> {
    val primes = LinkedHashSet<Int>()
    val booleanArray = BooleanArray(number) { true }
    booleanArray[0] = false
    booleanArray[1] = false
    for (i in 2..sqrt(number.toDouble()).toInt()) {
        if (!booleanArray[i])
            continue
        for (j in i * i until number step i) {
            booleanArray[j] = false
        }
    }
    booleanArray.forEachIndexed { index, b -> if (b) primes += index }
    return primes
}