package hidden.euler206

import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val minSqrt = sqrt(1000000000000000000.toDouble()).toLong()
    val maxSqrt = sqrt(1929394959697989990.toDouble()).toLong()
    for (i in maxSqrt downTo minSqrt) {
        val temp = (i * i).toString()
        if (
            temp[0] == '1'
            && temp[2] == '2'
            && temp[4] == '3'
            && temp[6] == '4'
            && temp[8] == '5'
            && temp[10] == '6'
            && temp[12] == '7'
            && temp[14] == '8'
            && temp[16] == '9'
            && temp[18] == '0'
        ) {
            println(i)
            break
        }
    }
}


/*
1 4
2 0
6 8

 */
private fun Long.isSquare() = with(sqrt(this.toDouble())) { this == floor(this) }