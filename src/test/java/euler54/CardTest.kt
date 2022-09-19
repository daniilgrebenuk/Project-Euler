package euler54

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CardTest {

    @Test
    fun compareTo() {
        val forTest = listOf(
            Card("KS"),
            Card("3H"),
            Card("TC"),
            Card("7H")
        )

        val expected = listOf(
            Card("3H"),
            Card("7H"),
            Card("TC"),
            Card("KS")
        )

        assertEquals(expected, forTest.sorted())
    }
}