package euler82

import java.nio.file.Files
import java.nio.file.Path
import kotlin.streams.toList

fun main() {
    /*val matrix = listOf(
        mutableListOf(CustomTriple(131), CustomTriple(673), CustomTriple(234), CustomTriple(103), CustomTriple(18)),
        mutableListOf(CustomTriple(201), CustomTriple(96), CustomTriple(342), CustomTriple(965), CustomTriple(150)),
        mutableListOf(CustomTriple(630), CustomTriple(803), CustomTriple(746), CustomTriple(422), CustomTriple(111)),
        mutableListOf(CustomTriple(537), CustomTriple(699), CustomTriple(497), CustomTriple(121), CustomTriple(956)),
        mutableListOf(CustomTriple(805), CustomTriple(732), CustomTriple(524), CustomTriple(37), CustomTriple(331)),
    )*/
    val matrix = Files.lines(Path.of("data-for-the-problems/euler82/p082_matrix.txt"))
        .map { it.split(",").map { num -> CustomTriple(num.toInt()) }.toMutableList() }
        .toList()
    var result = Int.MAX_VALUE;
    for (j in matrix[0].indices) {

        if (j > 0 && j < matrix[0].lastIndex) {
            matrix[0][j].left += matrix[0][j - 1].min
            matrix[0][j].top = Int.MAX_VALUE
            for (i in 1 until matrix.size) {
                matrix[i][j].left += matrix[i][j - 1].min
                matrix[i][j].top += matrix[i - 1][j].minTopLeft
            }
            matrix[matrix.lastIndex][j].bottom = Int.MAX_VALUE
            for (i in matrix.lastIndex - 1 downTo 0 ) {
                matrix[i][j].bottom += matrix[i + 1][j].minBottomLeft
            }
        }
        if (j == matrix[0].lastIndex) {
            for (i in matrix.indices) {
                matrix[i][j].left += matrix[i][j - 1].min
                result = minOf(matrix[i][j].left, result)
            }
        }
    }

    println(result)
}

data class CustomTriple(
    var top: Int,
    var left: Int,
    var bottom: Int,
) {
    val min
        get() = minOf(top, left, bottom)
    val minTopLeft
        get() = minOf(top, left)
    val minBottomLeft
        get() = minOf(bottom, left)

    constructor(num: Int) : this(num, num, num)
}