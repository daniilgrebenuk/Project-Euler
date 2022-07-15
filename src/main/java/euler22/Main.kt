package euler22

import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val names = Files.readString(Path.of("data-for-the-problems/euler22/p022_names.txt"))
        .replace("\"", "")
        .split(",")
        .sorted()
    println(names)
    var sum = 0L
    for ((index, name) in names.withIndex()) {
        sum += name.chars().map { it - 'A'.code + 1 }.sum() * (index + 1)
    }
    println(sum)
}
