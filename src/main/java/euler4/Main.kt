package euler4

fun main() {
    var res = 0
    for (i in 100..999) {
        for (j in 999 downTo i) {
            val temp = i * j
            if (temp <= res) {
                break
            }
            if (temp.toString() == temp.toString().reversed()) {
                res = temp
            }
        }
    }
    println(res)
}