package euler6

fun main() {
    var k = 100L
    var sumOfSqr = 0L
    var sum = 0L
    for (i in 1..k) {
        sumOfSqr += i * i
        sum += i
    }

    println(sum * sum - sumOfSqr)
}