package euler97

fun main() {
    val start = System.currentTimeMillis()
    var next = 1L
    for (i in 1..7830457) {
        next *= 2L
        next %= 10_000_000_000L
    }
    next *= 28433
    next %= 10_000_000_000L
    next += 1
    println(next)
    println(System.currentTimeMillis() - start)
}