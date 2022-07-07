package euler45

fun main() {
    val pentSet = (1L..1_000_000L).map { it * (3 * it - 1) / 2 }.toSet()
    val hexSet = (1L..1_000_000L).map { it * (2 * it - 1) }.toSet()

    for (number in (100..1_000_000L).map { it * (it + 1) / 2 }) {
        if (number > 40755 && pentSet.contains(number) && hexSet.contains(number)) {
            println(number)
            break
        }
    }
}