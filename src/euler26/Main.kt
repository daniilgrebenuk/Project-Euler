package euler26

fun main() {
    val d = 1000
    var maxLength = 0
    var result = 0
    for (i in 1 until 1000) {
        val temp = getRecurringCycleLength(i)
        if (temp > maxLength) {
            maxLength = temp
            result = i
        }
    }
    println(result)
}

fun getRecurringCycleLength(divider: Int): Int{
    var dividend = 1
    val set = LinkedHashSet<Int>()
    while (dividend % divider != 0) {
        if (dividend < divider) {
            if (set.contains(dividend)){
                return set.size - set.indexOf(dividend)
            }
            set.add(dividend)
            dividend *= 10
        } else {
            dividend %= divider
        }
    }
    return 0
}