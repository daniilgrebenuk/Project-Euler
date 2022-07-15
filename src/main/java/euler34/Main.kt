package euler34

fun main() {
    var sum = 0
    for (number in 3..1000000) {
        if (number.toString().chars().map { (it - 48).factorial() }.sum() == number) {
            sum += number
        }
    }
    println(sum)
}

fun Int.factorial(): Int {
    if (this == 1 || this == 0)
        return 1
    return this * (this - 1).factorial()
}