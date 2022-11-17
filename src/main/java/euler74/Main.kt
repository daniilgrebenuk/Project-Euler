package euler74

import java.util.LinkedList

val factorials = (0..9).calculateFactorials()

fun main() {
    println(
        (1..1_000_000).count { it.getChainFactorialDigitSum().size == 60 }
    )
}

private fun Int.getChainFactorialDigitSum(): Set<Int> {
    val set = LinkedHashSet<Int>()
    var currentNumber = this

    while (!set.contains(currentNumber)) {
        set += currentNumber
        currentNumber = currentNumber.calculateFactorialDigitSum()
    }

    return set
}

private fun Int.calculateFactorialDigitSum(): Int {
    return "$this".toCharArray().sumOf { factorials[it.digitToInt()] }
}

private fun IntRange.calculateFactorials():List<Int> {
    return this.map { it.factorial() }
}

private fun Int.factorial(): Int {
    return if (this in 0..1) 1 else this * (this - 1).factorial()
}