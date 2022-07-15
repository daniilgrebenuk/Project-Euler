package euler31

import java.util.*


fun main() {
    println(getCountCombination(200))
}

fun getCountCombination(coins: Int): Int {
    val coinsPrice = LinkedList(listOf(1, 2, 5, 10, 20, 50, 100, 200))
    while (coinsPrice.last > coins)
        coinsPrice.removeLast()
    fun combinations(currentCoinIndex: Int, remainingCoins: Int): Int {
        var counter = 0
        for (i in remainingCoins downTo 0 step coinsPrice[currentCoinIndex]) {
            if (i == 0)
                counter++
            else if (currentCoinIndex != 0)
                counter += combinations(currentCoinIndex - 1, i)
        }
        return counter
    }
    return combinations(coinsPrice.size - 1, coins)
}