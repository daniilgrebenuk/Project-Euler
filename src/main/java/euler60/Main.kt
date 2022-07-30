package euler60

import kotlin.math.sqrt

fun main() {
    var start = System.currentTimeMillis()
    val primes = getPrimesBelowNumber(100_000_000)
    val primesList = primes.toList().subList(0, 3_000)
    val primesMap = primesList.associateWith { LinkedHashSet<Int>() }

    OUTER@for ((index, prime) in primesList.withIndex()) {
        for (indexInner in index + 1 until primesList.size) {
            try {
                if (primes.contains("$prime${primesList[indexInner]}".toInt())
                    && primes.contains("${primesList[indexInner]}$prime".toInt())
                ) {
                    primesMap[prime]?.add(primesList[indexInner])
                    primesMap[primesList[indexInner]]?.add(prime)
                }
            }catch (_:Exception){
                if ("$prime${primesList[indexInner]}".toLong().isPrime()
                    && "${primesList[indexInner]}$prime".toLong().isPrime()
                ) {
                    primesMap[prime]?.add(primesList[indexInner])
                    primesMap[primesList[indexInner]]?.add(prime)
                }
            }
        }
    }

    fun checkPrimeToAddInAnswer(value: Int, answer: List<Int>): Boolean {
        if (answer.contains(value))
            return false
        for (prime in answer) {
            if (!primesMap[prime]!!.contains(value)) {
                return false
            }
        }
        return true
    }



    primesMap.filterValues { it.size >= 5 }.forEach { println("${it.key} = ${it.value}") }
    println("***********************************************")

    for (i in primesMap.filterValues { it.size >= 5 }.keys.sorted()) {
        val answers = ArrayList<List<Int>>()
        answers.add(listOf(i))
        for (prime in primesMap[i]!!) {
            val listsToAdd = ArrayList<List<Int>>()
            for (list in answers) {
                if (checkPrimeToAddInAnswer(prime, list)) {
                    listsToAdd += list
                }
            }
            for (list in listsToAdd){
                val temp = ArrayList(list)
                temp += prime
                if (temp.size == 5) {
                    println("Res -> $temp -> ${temp.sum()}")
                    println("Time: ${System.currentTimeMillis() - start}");
                    return
                }
                answers.add(temp)
            }
        }
    }

}

private fun Long.isPrime():Boolean{
    for (i in 2..sqrt(this.toDouble()).toLong()) {
        if(this % i == 0L){
            return false
        }
    }
    return true
}

private fun getPrimesBelowNumber(number: Int): Set<Int> {
    val primes = LinkedHashSet<Int>()
    val booleanArray = BooleanArray(number) { true }
    booleanArray[0] = false
    booleanArray[1] = false
    for (i in 2..sqrt(number.toDouble()).toInt()) {
        if (!booleanArray[i])
            continue
        for (j in i * i until number step i) {
            booleanArray[j] = false
        }
    }
    booleanArray.forEachIndexed { index, b -> if (b) primes += index }
    return primes
}