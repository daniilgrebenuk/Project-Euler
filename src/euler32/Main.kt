package euler32

fun main() {
    val numbers = HashSet<Int>()
    for (i in 10..99) {
        for (j in 100..999) {
            if (isPandigitalMultiply(i, j)) {
                numbers += i * j
            }
        }
    }
    for (i in 1..9) {
        for (j in 1000..10000) {
            if (isPandigitalMultiply(i, j)) {
                numbers += i * j
            }
        }
    }
    println(numbers.sum())
}

fun isPandigitalMultiply(n1: Int, n2: Int): Boolean {
    val multiply = n1 * n2
    val temp = "$n1$n2${multiply}"
    if (temp.length != 9 || temp.contains("0"))
        return false

    val set = HashSet<Int>()
    n1.toString().chars().forEach { set.add(it - 48) }
    n2.toString().chars().forEach { set.add(it - 48) }
    multiply.toString().chars().forEach { set.add(it - 48) }

    return set.size == 9
}