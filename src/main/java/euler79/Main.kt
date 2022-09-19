package euler79

import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.toList

fun main() {
    val enters = Files.lines(Path.of("data-for-the-problems/euler79/p079_keylog.txt")).toList().distinct()
    val password = enters.flatMap { it.toCharArray().toList() }.distinct().toMutableList()

    for (e in enters) {
        val chars = e.toCharArray()
        val indices = ArrayList<Int>()

        for (c in chars) {
            indices += password.indexOf(c)
        }
        indices.sort()
        for ((index, c) in chars.withIndex()) {
            password[indices[index]] = c
        }
    }

    println(password.joinToString(separator = ""))
}

/*


319

5983721

3 6 1

1 3 6

5381729



* */