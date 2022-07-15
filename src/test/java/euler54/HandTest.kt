package euler54

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HandTest {

    @Test
    fun correctInitialization() {
        val hand = Hand("8C TS KC 9H 4S")

        val actual = hand.cards

        val expected = listOf(
            Card("8C"),
            Card("TS"),
            Card("KC"),
            Card("9H"),
            Card("4S")
        )

        assertEquals(expected, actual)
    }
}