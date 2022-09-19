package euler62

fun main() {
    println(
        (1..10000L).map { it * it * it }
            .groupBy { it.toString().toCharArray().sorted() }
            .values
            .find { it.size == 5 }
            ?.get(0)
    )
}