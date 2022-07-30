package euler52

fun main() {
    OUTER@for (i in 1..10_000_000) {
        for (j in 2..6) {
            if (i.sortNumberInValue() != (i * j).sortNumberInValue()){
                continue@OUTER
            }
        }
        println(i)
        break
    }
}

fun Int.sortNumberInValue(): String = this.toString().toList().sorted().joinToString(separator = "")