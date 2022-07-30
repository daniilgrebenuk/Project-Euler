package euler57

import java.math.BigInteger

fun main() {
    var counter = 0
    for (i in 1..1000) {
        val fraction = calculateFraction(i)
        if(fraction.numerator.toString().length > fraction.denominator.toString().length)
            counter++
    }
    println(counter)
}

private fun calculateFraction(n: Int):Fraction {
    var fraction = 1 dv 2
    for (i in 1 until n){
        fraction = (fraction + 2).reverse()
    }

    return fraction + 1
}

private data class Fraction(val numerator: BigInteger, val denominator: BigInteger) {
    fun reverse() = Fraction(denominator, numerator)

    operator fun plus(n: Int) = Fraction(numerator + n.toBigInteger() * denominator, denominator)

    override fun toString() = "$numerator/$denominator"
}

private infix fun Int.dv(denominator: Int) = Fraction(this.toBigInteger(), denominator.toBigInteger())