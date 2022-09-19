package euler81

import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.toList

fun main() {
    val matrix = Files.lines(Path.of("data-for-the-problems/euler81/p081_matrix.txt"))
        .map { it.split(",").map { num -> num.toInt() }.toMutableList() }
        .toList()

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (i == 0 && j != 0) {
                matrix[i][j] += matrix[i][j - 1]
            } else if (j == 0 && i != 0) {
                matrix[i][j] += matrix[i - 1][j]
            } else if (i != 0) {
                matrix[i][j] += minOf(matrix[i][j - 1], matrix[i - 1][j])
            }
        }
    }

    println(matrix.last().last())
}