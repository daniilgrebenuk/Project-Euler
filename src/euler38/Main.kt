package euler38

fun main() {
    var res = 0
    for (i in 2..9999) {
        val temp = createPandigitalNumber(i)
        if (temp > res)
            res = temp
    }
    println(res)
}

fun createPandigitalNumber(number: Int): Int {
    var res = ""
    var counter = 1
    while (res.length < 9) {
        res += number * counter++
    }

    if (res.length != 9 || res.contains('0'))
        return 0
    for (i in 1..9) {
        if (!res.contains(i.toString())) {
            return 0
        }
    }
    return res.toInt()
}