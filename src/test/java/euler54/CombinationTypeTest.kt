package euler54

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CombinationTypeTest {

    @Test
    fun isRoyalFlush() {
        val royalFlushHand = Hand("TH KH AH QH JH")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.ROYAL_FLUSH,
                    royalFlushHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.ROYAL_FLUSH,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isStraightFlush() {
        val straightFlushHand = Hand("4H 6H 5H 8H 7H")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.STRAIGHT_FLUSH,
                    straightFlushHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.STRAIGHT_FLUSH,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isFourOfAKind() {
        val fourOfAKindHand = Hand("4H 6H 4C 4D 4S")
        val wrongHand = Hand("4H 6H 9D KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.FOUR_OF_A_KIND,
                    fourOfAKindHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.FOUR_OF_A_KIND,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isFullHouse() {
        val fullHouseHand = Hand("4H 6H 4C 4D 6S")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.FULL_HOUSE,
                    fullHouseHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.FULL_HOUSE,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isFlush() {
        val flushHand = Hand("4H 6H 9H KH 3H")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.FLUSH,
                    flushHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.FLUSH,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isStraight() {
        val straightHand = Hand("4H 6S 5D 2H 3H")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.STRAIGHT,
                    straightHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.STRAIGHT,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isThreeOfAKind() {
        val threeOfAKindHand = Hand("4H 6H 4D 4S 3H")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.THREE_OF_A_KIND,
                    threeOfAKindHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.THREE_OF_A_KIND,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isTwoPair() {
        val twoPairHand = Hand("4H 6H 4S KH 6D")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.TWO_PAIR,
                    twoPairHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.TWO_PAIR,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isOnePair() {
        val onePairHand = Hand("4H 6H 9H 4D 3H")
        val wrongHand = Hand("4H 6H 9H KH 3S")


        assertAll(
            {
                assertEquals(
                    CombinationType.ONE_PAIR,
                    onePairHand.getCombination()
                )
            },
            {
                assertNotEquals(
                    CombinationType.ONE_PAIR,
                    wrongHand.getCombination()
                )
            }
        )
    }

    @Test
    fun isHighCard() {
        val firstHand = Hand("4H 6H 9H KD 3H")
        val secondHand = Hand("4H 3S AD 8D JC")


        assertAll(
            {
                assertEquals(
                    CombinationType.HIGH_CARD,
                    firstHand.getCombination()
                )
            },
            {
                assertEquals(
                    CombinationType.HIGH_CARD,
                    secondHand.getCombination()
                )
            }
        )
    }

    @Test
    fun compareTwoRoyalFlesh() {
        val first = Hand("AH KH JH TH QH")
        val second = Hand("QC KC JC TC AC")

        assertEquals(0, first.compareTo(second))
    }

    @Test
    fun compareTwoStraightFlesh() {
        val first = Hand("9H KH JH TH QH")
        val second = Hand("8C 5C 7C TC 9C")
        val third = Hand("QD KD TD JD 9D")

        assertAll(
            { assertTrue(first > second) },
            { assertEquals(0, first.compareTo(third)) }
        )

    }

    @Test
    fun compareTwoFourOfAKind() {
        val first = Hand("4H 4D 4C TH 4S")
        val second = Hand("JC JH 5C JS JD")
        val third = Hand("KH 4D 4C 4H 4S")
        val fourth = Hand("4S 4D 4C 4H KS")


        assertAll(
            { assertTrue(first < second) },
            { assertTrue(first < third) },
            { assertEquals(0, third.compareTo(fourth)) }
        )
    }

    @Test
    fun compareTwoFullHouse() {
        val first = Hand("AH AD AS KH KC")
        val second = Hand("JH AD AS AH JC")
        val third = Hand("AH KD KS KH AC")
        val fourth = Hand("KD AD AS AH KC")

        assertAll(
            { assertTrue(first > second) },
            { assertTrue(first > third) },
            { assertTrue(second > third) },
            { assertEquals(0, first.compareTo(fourth)) }
        )
    }

    @Test
    fun compareTwoFlush() {
        val first = Hand("AH 5H 8H TH QH")
        val second = Hand("3C JC 7C TC 9C")
        val third = Hand("QC 6C JC 7C 9C")
        val fourth = Hand("QH 5H TH 8H AH")
        assertAll(
            { assertTrue(first > second) },
            { assertTrue(first > third) },
            { assertTrue(second < third) },
            { assertEquals(0, first.compareTo(fourth)) }
        )
    }

    @Test
    fun compareTwoStraight() {

        val first = Hand("9H KH JH TS QS")
        val second = Hand("8D 5C 7H TS 9C")
        val third = Hand("QD KH TC JD 9H")

        assertAll(
            { assertTrue(first > second) },
            { assertEquals(0, first.compareTo(third)) }
        )
    }

    @Test
    fun compareTwoThreeOfAKind() {
        val first = Hand("AH AC AS KH QH")
        val second = Hand("AH AC AS KH TH")
        val third = Hand("AH AC AS JH TH")
        val fourth = Hand("KH KC KS AH TH")
        val fifth = Hand("AS AC AH KS TD")


        assertAll(
            { assertTrue(first > second) },
            { assertTrue(first > third) },
            { assertTrue(third > fourth) },
            { assertEquals(0, second.compareTo(fifth)) }
        )
    }

    @Test
    fun compareTwoTwoPair() {
        val first = Hand("AH AS QD QC TH")
        val second = Hand("AH AS QD QC 7H")
        val third = Hand("KH KS QD QC TH")
        val fourth = Hand("AH AS TD TC JH")
        val fifth = Hand("AH AS QH QC TC")

        assertAll(
            { assertTrue(first > second) },
            { assertTrue(second > third) },
            { assertTrue(first > fourth) },
            { assertTrue(fourth > third) },
            { assertEquals(0, first.compareTo(fifth)) }
        )
    }

    @Test
    fun compareTwoOnePair() {
        val first = Hand("TH AC JH TS 3H")
        val second = Hand("QC QH JD TD AS")
        val third = Hand("TC AH JD TD QS")


        assertAll(
            { assertTrue(first < second) },
            { assertTrue(first < third) }
        )
    }

    @Test
    fun compareTwoHighCard() {
        val first = Hand("AH KD JH 5H QH")
        val second = Hand("QC KC 5C TD 3C")
        val third = Hand("AC KC 5C TD 3C")

        assertAll(
            { assertTrue(first > second) },
            { assertTrue(first > third) }
        )
    }


}