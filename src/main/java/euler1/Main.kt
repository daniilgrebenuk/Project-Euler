package euler1

fun main() {
    var result = 0
    for (num in 1 until 1000) {
        if (num % 3 == 0 || num % 5 == 0)
            result += num
    }
    println(result)
}