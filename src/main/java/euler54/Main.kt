package euler54

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    var counter = 0
    Files
        .lines(Path.of("data-for-the-problems/euler54/p054_poker.txt"))
        .forEach {
            if (Hand(it.substring(0, 14)) > Hand(it.substring(15, it.length)))
                counter++
        }
    println(counter)
}