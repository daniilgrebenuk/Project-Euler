package euler28

fun main() {
    val size = 1001
    var sum = 1
    var counter = 0
    var currentAdder = 2
    var currentNumber = 2

    while (currentNumber < size * size) {
        if (counter == 4) {
            counter = 0
            currentAdder += 2
            currentNumber++
            continue
        }

        currentNumber += currentAdder
        if(counter == 0){
            currentNumber--
        }

        sum += currentNumber
        counter++
    }
    println(sum)
}