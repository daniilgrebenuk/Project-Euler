package euler14

fun main() {
    val k = 1_000_000
    var result = 0
    var maxCount = 0
    for (startNumber in 2 until k) {
        var numberToIterate = startNumber.toLong()
        var counter = 0
        while (numberToIterate != 1L) {
            numberToIterate =
                if (numberToIterate % 2 == 0L) {
                    numberToIterate / 2
                } else {
                    3 * numberToIterate + 1
                }
            counter++
        }
        if (counter > maxCount) {
            maxCount = counter
            result = startNumber
        }
    }
    println(result)
}