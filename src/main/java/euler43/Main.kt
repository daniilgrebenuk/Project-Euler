package euler43

fun main() {
    val numbersToPermutation = "0123456789"
    var res = 0L
    for (number in permNumbers(numbersToPermutation).sorted().reversed())
        if (number.isPerfect())
            res += number.toLong()
    println(res)
}

private fun String.isPerfect(): Boolean = when {
    this.substring(1, 4).toInt() % 2 != 0 -> false
    this.substring(2, 5).toInt() % 3 != 0 -> false
    this.substring(3, 6).toInt() % 5 != 0 -> false
    this.substring(4, 7).toInt() % 7 != 0 -> false
    this.substring(5, 8).toInt() % 11 != 0 -> false
    this.substring(6, 9).toInt() % 13 != 0 -> false
    this.substring(7, 10).toInt() % 17 != 0 -> false
    else -> true
}


fun permNumbers(str: String): ArrayList<String> {
    val result = ArrayList<String>()
    val chars = str.toCharArray().toMutableList();

    fun recursivePermutation(chars: List<Char>, current: String) {
        if (chars.size > 1) {
            for (c in chars) {
                val nextChars = ArrayList(chars)
                nextChars.remove(c)
                val nextString = current + c
                if (!nextString.startsWith("0"))
                    recursivePermutation(nextChars, nextString)
            }
        } else {
            result.add(current + chars[0])
        }
    }

    recursivePermutation(chars, "")
    return result
}