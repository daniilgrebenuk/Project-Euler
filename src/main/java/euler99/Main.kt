package euler99

import java.math.BigDecimal
import java.math.MathContext
import java.nio.file.Files
import java.nio.file.Path
import kotlin.math.max

fun main() {
    val numbersWithPower = Files.readAllLines(Path.of("data-for-the-problems/euler99/p099_base_exp.txt"))
        .map { line ->
            line.trim().split(",").let {
                it[0].toInt() withPower  it[1].toInt()
            }
        }

    val start = System.currentTimeMillis()
    var max = numbersWithPower[0]
    var maxIndex = 0
    for (i in 1..numbersWithPower.lastIndex) {
        if (max < numbersWithPower[i]) {
            max = numbersWithPower[i]
            maxIndex = i
        }
    }
    println(maxIndex + 1)
    println("Time= ${System.currentTimeMillis() - start}")
}

infix fun Int.withPower(power: Int) = NumberWithPower(this.toBigDecimal(MathContext(20)), power)

data class NumberWithPower(val number: BigDecimal, val power: Int): Comparable<NumberWithPower> {
    override fun compareTo(other: NumberWithPower): Int {
        if (this.power == 1 && other.power == 1){
            return this.number.compareTo(other.number)
        }
        if (this.number > other.number && this.power > other.power) {
            return 1
        }
        if (this.number < other.number && this.power < other.power) {
            return -1
        }

        val thisIsMaximum = this.power > other.power
        val bigger: NumberWithPower
        val smaller: NumberWithPower

        if (thisIsMaximum) {
            bigger = this
            smaller = other
        } else {
            bigger = other
            smaller = this
        }

        if (bigger.power.toDouble() / smaller.power.toDouble() > 30000) {
            return this.number.pow(this.power, MathContext.UNLIMITED).compareTo(other.number.pow(other.power, MathContext.UNLIMITED))
        }

        val nextThis = NumberWithPower(
            smaller.number.divide(bigger.number, MathContext(20)),
            smaller.power
        )

        val nextOther = NumberWithPower(
            bigger.number,
            bigger.power - smaller.power
        )

        val nextIteration = nextThis.compareTo(nextOther)

        if (thisIsMaximum) {
            return nextIteration * (-1)
        }

        return nextIteration
    }

}



/*

2^11 < 3^7


2^11
----
 3^7

 2^7 * 2^4
 ---------
 3^7
%%%%%%%%%%%%%%%%%%%%


 (3/2)^7 > 2^4

 (3/2)^4 * (3/2)^3
 -----------------
 2^4

 (3/4)^4 * (3/2)^3
%%%%%%%%%%%%%%%%%%%%

(4/3)^4 < (3/2)^3


(4/3)^3 * (4/3)
-----------
(3/2)^3


(8/9)^3 * (4/3)

%%%%%%%%%%%%%%%%%%%%

(9/8)^3 > 4/3

9/8 * (9/8)^2
-----------
4/3

27/32 * (9/8)^2

%%%%%%%%%%%%%%%%%%%%%
32/27 < (9/8)^2


(9/8)/(32/27) * (9/8)

(9*27)/(8*32)

243/256 * 9/8

%%%%%%%%%%%%%%%%%%%%%
256/243 < 9/8

1.0535
1.125

 */