package euler68

import java.util.*

fun main() {
    val start = System.currentTimeMillis()
    var res = "0".repeat(1000)
    OUTER@ for (list in (1..10).toList().permuted()) {
        val temp = prepareList(list)
        for (i in 1 until list.size / 3) {
            if (temp[0] + temp[1] + temp[2] != temp[0 + i * 3] + temp[1 + i * 3] + temp[2 + i * 3])
                continue@OUTER
        }

        val tempS = temp.prepareString()
        if (tempS.length <= res.length)
            res = maxOf(res, tempS)
    }
    println(res)
    println("Time: ${System.currentTimeMillis() - start}")
}

private fun <T : Comparable<T>> List<T>.prepareString(): String {
    val index = this.findMinElementByStep()
    return "${this.subList(index, size).joinToString(separator = "")}${this.subList(0, index).joinToString(separator = "")}"
}

fun <T : Comparable<T>> List<T>.findMinElementByStep(step: Int = 3): Int {
    var temp = this[0]
    var res = 0
    for ((index, t) in withIndex()) {
        if (index % step == 0 && temp > t) {
            temp = t
            res = index
        }
    }
    return res
}

private fun <T> prepareList(list: LinkedList<T>): List<T> {
    val numberOfBranch = list.size / 2
    for (i in 0 until numberOfBranch - 1) {
        list.add(4 + i * 3, list[2 + i * 3])
    }
    list.add(list[1])
    return list
}


private fun <T> List<T>.permuted(): List<LinkedList<T>> {
    val linkedList = LinkedList(this)
    val result = ArrayList<LinkedList<T>>()

    fun recursivePermutation(nextList: LinkedList<T>) {
        if (linkedList.isEmpty()) {
            result += nextList
            return
        }
        for (i in linkedList.indices) {
            linkedList.addLast(with(LinkedList(nextList)) {
                val next = linkedList.removeFirst()
                this.add(next)
                recursivePermutation(this)
                next
            })
        }
    }

    recursivePermutation(LinkedList())
    return result
}

