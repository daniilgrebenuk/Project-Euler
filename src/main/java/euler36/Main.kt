package euler36

fun main() {
    var sum = 0
    for (i in 1..1_000_000) {
        if (i.isFullPalindromic())
            sum += i
    }
    println(sum)
}

private fun Int.isFullPalindromic(): Boolean = isPalindromic(this.toString()) && isPalindromic(this.toString(2))

private fun isPalindromic(s: String): Boolean {
    val chars = s.toCharArray()
    for (i in 0..chars.size / 2) {
        if (chars[i] != chars[chars.size - i - 1])
            return false
    }
    return true
}

