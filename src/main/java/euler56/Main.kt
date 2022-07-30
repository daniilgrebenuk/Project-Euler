package euler56

fun main() = println(
    (1..99)
        .flatMap { a ->
            (1..99)
                .map { b ->
                    a.toBigInteger().pow(b)
                }
        }
        .maxOf { it.toString().chars().map { c -> c - 48 }.sum() }
)