package euler25

import java.math.BigInteger

fun main() {
    var first = BigInteger.ONE
    var second = first
    var counter = 2
    while (second.toString().length < 1000) {
        val temp = second
        second += first
        first = temp
        counter++
    }
    println(counter)
}