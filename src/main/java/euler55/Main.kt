package euler55

import java.math.BigInteger

fun main() = println((1..10000).count { it.isLychrelNumber() })

private fun Int.isLychrelNumber(): Boolean {
    var temp = this.toBigInteger()
    for (i in 1..50) {
        temp += temp.reversed()
        if (temp.isPalindrome())
            return false
    }
    return true
}

private fun BigInteger.reversed() = this.toString().reversed().toBigInteger()

private fun BigInteger.isPalindrome() = this == this.reversed()