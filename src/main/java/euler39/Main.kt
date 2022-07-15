package euler39

import kotlin.math.round
import kotlin.math.sqrt


fun main() {
    val map = HashMap<Int, Int>()
    for (a in 1..400) {
        for (b in a..500) {
            val c = a pif b
            if (c > 0) {
                map.merge(a + b + c, 1) { n1, n2 -> n1 + n2 }
            }
        }
    }
    println(map.maxByOrNull { it.value }?.key)
}

infix fun Int.pif(int: Int): Int {
    val hypotenuse = sqrt((this * this + int * int).toDouble())
    if (hypotenuse == round(hypotenuse)) {
        return hypotenuse.toInt()
    }
    return -1
}
