package euler66


import java.math.BigInteger
import kotlin.math.floor
import kotlin.math.sqrt


fun main() {
    var max = BigInteger.ZERO
    var ans = 0
    for (i in 2..1000) {
        if (!i.isSquare()) {
            val res = find(i)
            if (max < res.first) {
                max = res.first
                ans = i
            }
        }
    }
    println(ans)
}

private fun find(dTemp: Int): Pair<BigInteger, BigInteger> {
    val (adder, period) = findPeriodFromSqrt(dTemp)
    val d = dTemp.toBigInteger()
    for (i in 0..Int.MAX_VALUE) {
        val (x, y) = FractionContainer.calculateFraction(adder, i, period)
        if (x.toString().length > 100)
            return BigInteger("-1") to BigInteger("-1")

        if (isCorrectAnswer(x, y, d)) {
            return x to y
        }
    }
    return BigInteger.ZERO to BigInteger.ZERO
}

private fun isCorrectAnswer(x: BigInteger, y: BigInteger, d: BigInteger) = ((x * x) - d * (y * y)) == BigInteger.ONE

private fun Int.isSquare() = with(sqrt(this.toDouble())) { this == floor(this) }

private fun findPeriodFromSqrt(number: Int): Pair<Int, List<Int>> {
    if (number.isSquare())
        return 0 to listOf()

    val result = ArrayList<Int>()
    val pair = Fraction.sqrtToFraction(number)
    val fraction = pair.second
    var nextFraction = fraction.nextFraction
    result += fraction.adder

    while (fraction != nextFraction) {
        result += nextFraction.adder
        nextFraction = nextFraction.nextFraction
    }

    return pair.first to result
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