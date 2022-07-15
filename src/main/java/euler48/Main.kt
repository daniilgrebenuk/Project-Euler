package euler48

fun main() {
    println(
            (1..1000)
                    .map { it.toBigInteger().pow(it) }
                    .reduce { b1, b2 -> b1 + b2 }
                    .toString()
                    .takeLast(10)
    )
}