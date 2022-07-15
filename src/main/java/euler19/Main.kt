package euler19

import java.time.DayOfWeek
import java.time.LocalDate

fun main() {
    var counter = 0
    for (year in 1901..2000) {
        for (month in 1..12) {
            if (LocalDate.of(year, month, 1).dayOfWeek == DayOfWeek.SUNDAY)
                counter++
        }
    }
    println(counter)
}