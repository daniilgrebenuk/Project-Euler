package euler17

fun main() {
    val numbers = mapOf(
        1 to 3,
        2 to 3,
        3 to 5,
        4 to 4,
        5 to 4,
        6 to 3,
        7 to 5,
        8 to 5,
        9 to 4,
        10 to 3,
        11 to 6,
        12 to 6,
        13 to 8,
        14 to 8,
        15 to 7,
        16 to 7,
        17 to 9,
        18 to 8,
        19 to 8,
        20 to 6,
        30 to 6,
        40 to 5,
        50 to 5,
        60 to 5,
        70 to 7,
        80 to 6,
        90 to 6,
        100 to 7,
        1000 to 8
    )

    val from = 1
    val to = 1000

    var counter = 0
    for (i in from..to) {
        var number = i
        if (number >= 1000) {
            val temp = number - (number % 1000)
            counter += numbers[temp / 1000]!!
            counter += numbers[1000]!!
            number -= temp
        }
        if (number >= 100) {
            val temp = number - (number % 100)
            counter += numbers[temp / 100]!!
            counter += numbers[100]!!
            number -= temp
            if (number != 0)
                counter += 3
        }
        if (number >= 20) {
            val temp = number - (number % 10)
            counter += numbers[temp]!!
            number -= temp
        }
        if (number >= 1) {
            counter += numbers[number]!!
        }
    }
    println(counter)
}