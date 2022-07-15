package euler44

fun main() {
    val pentSet = LinkedHashSet<Long>()
    for (i in 1L..10_000)
        pentSet.add(i * (3 * i - 1) / 2)

    val pentList = pentSet.toList();


    for ((indexP1, p1) in pentList.withIndex()) {
        for (indexP2 in indexP1 until pentList.size) {
            if (pentSet.contains(p1 + pentList[indexP2]) && pentSet.contains(pentList[indexP2] - p1)) {
                println("${pentList[indexP2] - p1}")
                return
            }
        }
    }
}