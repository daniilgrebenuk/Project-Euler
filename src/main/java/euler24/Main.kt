package euler24

fun main() {
    val numberOfElement = 1_000_000
    val startString = "0123456789"
    println(getPermutationOfString(startString)[numberOfElement - 1])
}

fun getPermutationOfString(string: String):List<String> {
    val permutations = ArrayList<String>()
    fun recursivePermutation(currentString: String, remaining: List<Char>) {
        if (remaining.isNotEmpty()){
            for (c in remaining) {
                val nextString = currentString + c
                val nextRemaining = ArrayList(remaining)
                nextRemaining -= c
                recursivePermutation(nextString, nextRemaining)
            }
        }else{
            permutations += currentString
        }
    }
    recursivePermutation("", string.toCharArray().toList())

    return permutations.sorted()
}


