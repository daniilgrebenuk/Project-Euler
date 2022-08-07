package euler63

fun main() {
    var counter = 0
    for (i in 1..9) {
        for (j in 1..Int.MAX_VALUE) {
            if (i.toBigInteger().pow(j).toString().length == j)
                counter++
            else
                break
        }
    }
    println(counter)
}