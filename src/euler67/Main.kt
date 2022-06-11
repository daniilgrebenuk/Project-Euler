package euler67

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.max

fun main() {
    val triangle = Files.readString(Paths.get("data-for-the-problems/euler67/p067_triangle.txt"))!!.trimIndent()

    val triangleNumbers = triangle
        .split("\n")
        .stream()
        .map { line ->
            line.trim()
                .split(" ")
                .stream()
                .map(String::toInt)
                .toArray { size -> Array(size) { 0 } }
        }.toArray { size -> Array(size) { arrayOf(0) } }

    for (i in triangleNumbers.size - 2 downTo 0) {
        for (j in triangleNumbers[i].indices) {
            triangleNumbers[i][j] += max(
                triangleNumbers[i + 1][j],
                triangleNumbers[i + 1][j + 1]
            )
        }
    }

    println(triangleNumbers[0][0])
}