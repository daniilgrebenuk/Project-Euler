package euler2

fun main() {
    var fistNumber = 1
    var secondNumber = 1
    var result = 0
    while (secondNumber < 4_000_000) {
        if (secondNumber % 2 == 0)
            result += secondNumber
        val temp = secondNumber
        secondNumber += fistNumber
        fistNumber = temp
    }

    println(result)
}
