package euler61

import java.util.*

fun main() {
    val start = System.currentTimeMillis()
    val elements = listOf(
        createSet(0) { it * (it + 1) / 2 },
        createSet(1) { it * it },
        createSet(2) { it * (3 * it - 1) / 2 },
        createSet(3) { it * (2 * it - 1) },
        createSet(4) { it * (5 * it - 3) / 2 },
        createSet(5) { it * (3 * it - 2) }
    )
    val indexes = LinkedList((0..5).toList())

    fun recursive(lastElements: List<Pair<Int, Int>> = listOf()): Boolean {
        if (indexes.size != 0) {
            for (i in indexes.indices) {
                val tempIndex = indexes.removeFirst()
                if (lastElements.isEmpty()) {
                    elements[tempIndex].forEach {
                        if (recursive(lastElements + it)) return true
                    }
                } else {
                    elements[tempIndex].filter { lastElements.last().second % 100 == it.second / 100 }.forEach {
                        if (recursive(lastElements + it)) return true
                    }
                }
                indexes.addLast(tempIndex)
            }
        } else if (lastElements[0].second / 100 == lastElements.last().second % 100) {
            println(lastElements.sumOf { it.second })
            return true
        }
        return false
    }

    recursive()
    println("Time: ${System.currentTimeMillis() - start}")
}

fun createSet(idSet: Int, predicate: (Int) -> Boolean = { it in 1000..9999 }, gen: (Int) -> Int): Set<Pair<Int, Int>> {
    var flag = 0
    var counter = 1
    val set = HashSet<Pair<Int, Int>>()
    while (flag < 2) {
        when (flag) {
            0 -> gen(counter).apply {
                if (predicate(this)) {
                    flag++
                    set += idSet to this
                }
            }
            1 -> gen(counter).apply {
                if (predicate(this)) {
                    set += idSet to this
                } else {
                    flag++
                }
            }
        }
        counter++
    }
    return set
}