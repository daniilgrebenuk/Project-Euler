package euler42

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val names = Files
        .readString(Paths.get("data-for-the-problems/euler42/p042_words.txt"))
        .replace("\"", "")
        .split(",")

    var adder = 1
    var last = 0
    val setOfTriangleNumber = LinkedHashSet<Int>()
    for (i in 0..20) {
        last = (last + adder++).also { setOfTriangleNumber += it }
    }

    var counter = 0
    names.forEach {
        if (setOfTriangleNumber.contains(it.chars().map { c -> c + 1 - 'A' .code}.sum())) counter++
    }
    println(counter)
}

