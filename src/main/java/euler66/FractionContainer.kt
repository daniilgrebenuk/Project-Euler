package euler66

import java.math.BigInteger


data class FractionContainer(val numerator: BigInteger, val denominator: BigInteger) {
    companion object {
        fun calculateFraction(adder: Int, depth: Int, periodTemp: List<Int>): FractionContainer {
            var index = depth % periodTemp.size
            var fraction = 1 dv periodTemp[index--]
            for (i in 1..depth) {
                if (index == -1)
                    index = periodTemp.size - 1
                fraction = (fraction + periodTemp[index--]).reverse()
            }

            return fraction + adder
        }
    }

    fun reverse() = FractionContainer(denominator, numerator)

    operator fun plus(n: Int) = FractionContainer(numerator + n.toBigInteger() * denominator, denominator)

    override fun toString() = "$numerator/$denominator"
}

private infix fun Int.dv(denominator: Int) = FractionContainer(this.toBigInteger(), denominator.toBigInteger())