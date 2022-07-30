package euler53


import java.math.BigInteger

fun main() {
    var counter = 0
    for (n in 1..100) {
        for (r in 0..n) {
            if (n.factorial() / (r.factorial() * (n - r).factorial()) > 1_000_000.toBigInteger())
                counter++
        }
    }
    println(counter)
}

private fun Int.factorial(): BigInteger {
    if (this == 0 || this == 1)
        return 1.toBigInteger()

    return this.toBigInteger() * (this - 1).factorial()
}