package euler40

import kotlin.math.pow

fun main() {
    val start = System.currentTimeMillis()
    val numbers = StringBuilder()
    var nextNumber = 1
    var res = 1
    for (i in 0..6) {
        while (true)
            try {
                res *= numbers[(10.0).pow(i).toInt() - 1].digitToInt()
                break
            } catch (e: Exception) {
                numbers.append(nextNumber++)
            }
    }
    println(res)
}