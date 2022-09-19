package euler76

fun main() {
    var result = 0

    fun recursive(current: Int, sub: Int) {
        if (sub == 1) {
            result++
            return
        }
        for (i in 0..current step sub) {
            if (current - i == 0) {
                result++
                return
            }
            recursive(current - i, sub - 1)
        }
    }
    recursive(100, 99)
    println(result)
}