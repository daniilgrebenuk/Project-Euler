package euler71

fun main() {
    val k = 3.0 / 7
    val limit = (1_000_000 * k).toInt()
    var res = 1 to 1.0
    for (i in 1 until limit) {
        for (j in (i.toDouble() / k).toInt() + 1000 downTo 1) {
            val temp = k - i.toDouble() / j
            if (temp <= 0) {
                break
            }
            if (temp < res.second) {
                res = i to temp
            }
        }
    }
    println(res.first)
}