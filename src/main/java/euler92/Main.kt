package euler92

fun main() {
    val set = mutableSetOf(89)
    var counter = 0
    for (i in 2..10_000_000) {
        val tempSet = linkedSetOf(i)
        var next = i.toString().toCharArray().map { it.digitToInt() }.fold(0) { acc, i -> acc + i * i }
        while (true) {
            if (next == 1) {
                break
            }

            if (set.contains(next)) {
                set += tempSet
                counter++
                break
            }
            tempSet += next
            next = next.toString().toCharArray().map { it.digitToInt() }.fold(0) { acc, i -> acc + i * i }
        }
    }
    println(counter)
}