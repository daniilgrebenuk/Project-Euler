package euler58

import kotlin.math.sqrt

fun main() {
    var primeCounter = .0
    var notPrimeCounter = 1.0

    var spiralCounter = 0
    var next = 2
    var adder = 2
    while (true) {
        if (spiralCounter == 0) {
            next += adder - 1
        } else if (spiralCounter == 4) {
            next++
            spiralCounter = 0
            adder += 2

            if (primeCounter / (primeCounter + notPrimeCounter) < .10) {
                println(adder - 1)
                break
            }
            continue
        } else {
            next += adder
        }
        spiralCounter++
        if ((next).isPrime()) {
            primeCounter++
        } else {
            notPrimeCounter++
        }
    }


}

private fun Int.isPrime(): Boolean {
    for (i in 2..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0)
            return false
    }
    return true
}