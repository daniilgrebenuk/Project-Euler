package euler89

import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.toList

fun main() {
    val numbers = Files.lines(Path.of("data-for-the-problems/euler89/p089_roman.txt")).toList()
    var res = 0
    numbers.forEach {
        val normal = it.romanToInt()
        val roman = normal.toRoman()
        res += it.length - roman.length
    }
    println(res)
}

fun String.romanToInt(): Int {
    var result = 0
    val chars = this.toCharArray()
    var index = 0
    while (index < chars.size) {
        result += when (chars[index]) {
            'I' -> {
                if (index + 1 < chars.size && chars[index + 1] == 'V') {
                    index++
                    4
                } else if (index + 1 < chars.size && chars[index + 1] == 'X') {
                    index++
                    9
                } else {
                    1
                }
            }
            'V' -> 5
            'X' -> {
                if (index + 1 < chars.size && chars[index + 1] == 'L') {
                    index++
                    40
                } else if (index + 1 < chars.size && chars[index + 1] == 'C') {
                    index++
                    90
                } else {
                    10
                }
            }
            'L' -> 50
            'C' -> {
                if (index + 1 < chars.size && chars[index + 1] == 'D') {
                    index++
                    400
                } else if (index + 1 < chars.size && chars[index + 1] == 'M') {
                    index++
                    900
                } else {
                    100
                }
            }
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
        index++
    }
    return result
}

fun Int.toRoman(): String {
    val result = StringBuilder()
    var number = this

    fun process(sub: Int, sign: String) {
        while (number - sub >= 0) {
            result.append(sign)
            number -= sub
        }
    }

    //process(4000,  "CM")
    process(1000, "M")
    process(900, "CM")
    process(500, "D")
    process(400, "CD")
    process(100, "C")
    process(90, "XC")
    process(50, "L")
    process(40, "XL")
    process(10, "X")
    process(9, "IX")
    process(5, "V")
    process(4, "IV")
    process(1, "I")



    return result.toString()
}