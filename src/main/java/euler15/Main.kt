package euler15

const val size = 20

fun main() {
    val fields = Array(size + 1) { Array(size + 1) { 0L } }
    println(getCountOfWays(array = fields, x = 0, y = 0))
}

fun getCountOfWays(array: Array<Array<Long>>, x: Int, y: Int): Long {
    if (array[y][x] != 0L) {
        return array[y][x]
    }
    if (y == size || x == size) {
        array[y][x] = 1L
        return array[y][x]
    }

    array[y][x] = getCountOfWays(array = array, x = x + 1, y = y) + getCountOfWays(array = array, x = x, y = y + 1)
    return array[y][x]
}