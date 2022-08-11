package euler65

import euler66.FractionContainer

fun main() {
    println(FractionContainer.calculateFraction(2,98, getEList()).numerator.toString().map { it.digitToInt() }.sumOf { it })
}

fun getEList(): List<Int> {
    val res = ArrayList<Int>()
    res += 1
    res += 2

    var adder = 4;

    for (i in 1..100){
        res += 1
        res += 1
        res += adder
        adder += 2
    }

    return res
}