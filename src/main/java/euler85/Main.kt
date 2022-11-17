package euler85

import kotlin.math.absoluteValue

fun main() {
    var minSubtract = 2_000_000
    var res = -1

    for (x in 1..300) {
        for (y in x..300) {
            val countOfSquare= findSquaresByHeightAndWidth(x, y)
            val temp = (countOfSquare - 2_000_000).absoluteValue
            if (temp < minSubtract) {
                minSubtract = temp
                res = x * y
            } else if (countOfSquare > 2_000_000) {
                continue
            }
        }
    }
    println(res)
}

private fun findSquaresByHeightAndWidth(height: Int, width: Int): Int {
    val subFactorialOfHeight = height.subFactorial()
    return (1..width).sumOf { it * subFactorialOfHeight }
}

private fun Int.subFactorial(): Int {
    return if (this in 0..1) 1 else this + (this - 1).subFactorial()
}