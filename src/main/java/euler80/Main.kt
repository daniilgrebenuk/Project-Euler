package euler80

import java.math.MathContext

fun main() {
    println(
        (1..100)
            .map {
                it.toBigDecimal().sqrt(MathContext(105)).toString().replace(".", "")
            }
            .filter { it.length > 10 }
            .sumOf { number ->
                number.substring(0, 100).toCharArray().sumOf { it.digitToInt() }
            }
    )
}
