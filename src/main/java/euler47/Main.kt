package euler47

fun main() {
    var start = System.currentTimeMillis()
    for (number in 1..1_000_000) {
        if (
            (number).divisorCount() == 4 &&
            (number + 1).divisorCount() == 4 &&
            (number + 2).divisorCount() == 4 &&
            (number + 3).divisorCount() == 4
        ) {
            println(number)
            break
        }
    }
    println(System.currentTimeMillis() - start)
}

private fun Int.divisorCount(): Int {
    var current = this
    var counter = 0
    if (current % 2 == 0) {
        counter++
        while (current % 2 == 0)
            current /= 2
    }
    var divisor = 3
    while (current > 1) {
        if (current % divisor == 0) {
            counter++
            while (current % divisor == 0)
                current /= divisor
        }
        divisor += 2
    }
    return counter
}