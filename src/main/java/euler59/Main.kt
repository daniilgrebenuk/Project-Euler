package euler59

import java.nio.file.Files
import java.nio.file.Path
import kotlin.experimental.xor

fun main() {
    val bytes = Files.readString(Path.of("data-for-the-problems/euler59/p059_cipher.txt")).split(",").map { it.toByte() }

    fun resolveBytes(vararg chars: Char): String {
        val res = ArrayList(bytes)
        val bytesToDecrypt = chars.map { it.code.toByte() }
        var counter = 0
        for (i in bytes.indices) {
            res[i] = res[i] xor bytesToDecrypt[counter++]
            if (counter == bytesToDecrypt.size) {
                counter = 0
            }
        }
        return String(res.toByteArray())
    }

    for (a in 'a'..'z') {
        for (b in 'a'..'z') {
            for (c in 'a'..'z') {
                val temp = resolveBytes(a, b, c)
                if (temp.contains("and") && temp.contains("the") && temp.contains("this")){
                    println(temp.chars().sum())
                }
            }
        }
    }
}

