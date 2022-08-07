package euler64

import kotlin.math.floor
import kotlin.math.sqrt


fun main() {
    var res = 0
    for (i in 2..10_000) {
        if (i.isSquare())
            continue
        val fraction = Fraction.sqrtToFraction(i).second//(1, Numerator(23, 3), 7)
        var nextFraction = fraction.nextFraction
        var counter = 1

        while (fraction != nextFraction) {
            nextFraction = nextFraction.nextFraction
            counter++
        }
        if (counter % 2 != 0) {
            res++
        }
    }
    println(res)
}


private data class Fraction(val adder: Int, val numerator: Numerator, val denominator: Int) {
    companion object {
        fun sqrtToFraction(number: Int): Pair<Int, Fraction> {
            val sqrt = sqrt(number.toDouble()).toInt()
            return sqrt to Fraction(0, Numerator(number, sqrt), 1).nextFraction
        }
    }

    val sqrt: Int = sqrt(numerator.sqr.toDouble()).toInt()

    val nextFraction: Fraction
        get() {
            val sqrtTemp = sqrt
            val denominator = numerator.nextDenominator(denominator)
            var numeratorAdder = numerator.adder * (-1)
            var counter = 0
            while (numeratorAdder + denominator <= sqrtTemp) {
                numeratorAdder += denominator
                counter++
            }
            return Fraction(counter, Numerator(numerator.sqr, numeratorAdder), denominator)
        }
}

private data class Numerator(val sqr: Int, val adder: Int) {
    fun nextDenominator(divisor: Int) = (sqr - adder * adder) / divisor
}


private fun Int.isSquare() = with(sqrt(this.toDouble())) { this == floor(this) }