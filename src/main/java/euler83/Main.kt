package euler83

import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.toList

fun main() {
    /*val matrix = listOf(
        mutableListOf(CustomField(131), CustomField(673), CustomField(234), CustomField(103), CustomField(18)),
        mutableListOf(CustomField(201), CustomField(96), CustomField(342), CustomField(965), CustomField(150)),
        mutableListOf(CustomField(630), CustomField(803), CustomField(746), CustomField(422), CustomField(111)),
        mutableListOf(CustomField(537), CustomField(699), CustomField(497), CustomField(121), CustomField(956)),
        mutableListOf(CustomField(805), CustomField(732), CustomField(524), CustomField(37), CustomField(331)),
    )*/
    val matrix = Files.lines(Path.of("data-for-the-problems/euler83/p083_matrix.txt"))
        .map { it.split(",").map { num -> CustomField(num.toInt()) }.toMutableList() }
        .toList()

    val limit = (matrix.size + matrix[0].size) * 5
    matrix[0][0].currentWeight = matrix[0][0].fieldWeight
    val endIndex = matrix.lastIndex to matrix[0].lastIndex

    fun recursive(from: Origin, y: Int, x: Int, d: Int) {
        if (endIndex == y to x) {
            return
        }
        if (d > limit) {
            return
        }
        if (from != Origin.LEFT) {
            if (x != 0 && matrix[y][x - 1].calculatePath(matrix[y][x])) {
                recursive(Origin.RIGHT, y, x - 1, d + 1)
            }
        }
        if (from != Origin.TOP) {
            if (y != 0 && matrix[y - 1][x].calculatePath(matrix[y][x])) {
                recursive(Origin.BOTTOM, y - 1, x, d + 1)
            }
        }
        if (from != Origin.RIGHT) {
            if (x != matrix[0].lastIndex && matrix[y][x + 1].calculatePath(matrix[y][x])) {
                recursive(Origin.LEFT, y, x + 1, d + 1)
            }
        }
        if (from != Origin.BOTTOM) {
            if (y != matrix.lastIndex && matrix[y + 1][x].calculatePath(matrix[y][x])) {
                recursive(Origin.TOP, y + 1, x, d + 1)
            }
        }
    }
    recursive(Origin.LEFT, 0, 0, 0)
    println(matrix[endIndex.first][endIndex.second].currentWeight)
}

enum class Origin {
    LEFT, TOP, RIGHT, BOTTOM;
}

data class CustomField(
    var fieldWeight: Int,
    var currentWeight: Int = Int.MAX_VALUE,
) {
    fun calculatePath(customField: CustomField): Boolean {
        val temp = customField.currentWeight + fieldWeight
        if (temp < 0) {
            println(this)
        }
        if (temp in 1 until currentWeight) {
            currentWeight = temp
            return true
        }
        return false
    }
}