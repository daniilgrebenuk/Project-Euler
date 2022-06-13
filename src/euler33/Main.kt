package euler33

fun main() {
    val pairs = ArrayList<Pair<Int, Int>>()
    for (i in 10..99) {
        for (j in i..99) {
            if (isNonTrivial(i, j)) {
                pairs.add(i to j)
            }
        }
    }
    val firstDivisors = ArrayList<Int>()
    val secondDivisors = ArrayList<Int>()

    pairs.forEach {
        firstDivisors.addAll(getDivisors(it.first))
        secondDivisors.addAll(getDivisors(it.second))
    }

    for (i in firstDivisors) {
        secondDivisors.remove(i)
    }

    println(secondDivisors.reduce { n1, n2 -> n1 * n2 })
}

fun getDivisors(number: Int): MutableList<Int> {
    var toFind = number
    var divisor = 2
    val result = ArrayList<Int>()

    while (toFind != 1) {
        if (toFind % divisor == 0) {
            while (toFind % divisor == 0) {
                result += divisor
                toFind /= divisor
            }
        }
        divisor++
    }

    return result
}

fun isNonTrivial(numerator: Int, denominator: Int): Boolean {
    val list = ArrayList<Int>()
    val tempNumerator = numerator.toString()
    val tempDenominator = denominator.toString()

    if (tempNumerator.endsWith('0') && tempDenominator.endsWith('0'))
        return false

    tempNumerator.chars()
        .forEach { if (!(tempNumerator.contains(it.toChar()) && tempDenominator.contains(it.toChar()))) list += it - 48 }
    tempDenominator.chars()
        .forEach { if (!(tempNumerator.contains(it.toChar()) && tempDenominator.contains(it.toChar()))) list += it - 48 }

    if (list.size != 2)
        return false
    return list[0].toDouble() / list[1].toDouble() == numerator.toDouble() / denominator.toDouble()
}
