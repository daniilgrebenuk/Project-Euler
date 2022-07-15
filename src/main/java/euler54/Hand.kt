package euler54

import euler54.CombinationType.Companion.compareTwoHandWithSameCombination
import euler54.CombinationType.Companion.getCombinationFromHand

class Hand(val cards: List<Card>) : Comparable<Hand> {

    constructor(cards: String) : this(cards.split(" ").map(::Card))

    fun getCombination() = getCombinationFromHand(this)

    override operator fun compareTo(other: Hand): Int {
        val comparedCombinations = getCombination().compareTo(other.getCombination())
        if (comparedCombinations != 0) {
            return comparedCombinations
        }
        return compareTwoHandWithSameCombination(this, other)
    }
}

enum class CombinationType {
    HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;

    companion object {
        fun getCombinationFromHand(hand: Hand) = when {
            isRoyalFlush(hand) -> ROYAL_FLUSH
            isStraightFlush(hand) -> STRAIGHT_FLUSH
            isFourOfKnight(hand) -> FOUR_OF_A_KIND
            isFullHouse(hand) -> FULL_HOUSE
            isFlush(hand) -> FLUSH
            isStraight(hand) -> STRAIGHT
            isThreeOfAKind(hand) -> THREE_OF_A_KIND
            isTwoPair(hand) -> TWO_PAIR
            isOnePair(hand) -> ONE_PAIR
            else -> HIGH_CARD
        }

        private fun isRoyalFlush(hand: Hand) = isStraightFlush(hand) && hand.cards.any { it.rank == Rank.ACE }

        private fun isStraightFlush(hand: Hand) = isFlush(hand) && isStraight(hand)

        private fun isFourOfKnight(hand: Hand) = hand.cards.groupingBy { it.rank }.eachCount().any { it.value == 4 }

        private fun isFullHouse(hand: Hand) = hand.cards.map { it.rank }.distinct().size == 2

        private fun isFlush(hand: Hand) = hand.cards.map { it.suit }.distinct().size == 1

        private fun isStraight(hand: Hand): Boolean {
            val sortedCards = hand.cards.sorted()

            for (c in 0 until sortedCards.size - 1) {
                if (sortedCards[c].rank.ordinal + 1 != sortedCards[c + 1].rank.ordinal) {
                    return false
                }
            }

            return true
        }

        private fun isThreeOfAKind(hand: Hand) = hand.cards.groupingBy { it.rank }.eachCount().any { it.value == 3 }

        private fun isTwoPair(hand: Hand) = hand.cards.groupingBy { it.rank }.eachCount().filter { it.value == 2 }.size == 2

        private fun isOnePair(hand: Hand) = hand.cards.groupingBy { it.rank }.eachCount().any { it.value == 2 }

        fun compareTwoHandWithSameCombination(first: Hand, second: Hand) = when (first.getCombination()) {
            ROYAL_FLUSH -> 0
            STRAIGHT_FLUSH, STRAIGHT, FLUSH -> compareTwoStraight(first, second)
            FOUR_OF_A_KIND, FULL_HOUSE -> compareTwoFourOfAKindOrFullHouse(first, second)
            THREE_OF_A_KIND, ONE_PAIR -> compareTwoOnePare(first, second)
            TWO_PAIR -> compareTwoTwoPare(first, second)
            HIGH_CARD -> compareTwoHighCard(first, second)
        }

        private fun compareTwoFourOfAKindOrFullHouse(first: Hand, second: Hand): Int {
            val firstCards = first.cards.groupingBy { it.rank }.eachCount().entries.sortedBy { it.value }.map { it.key }
            val secondCards = second.cards.groupingBy { it.rank }.eachCount().entries.sortedBy { it.value }.map { it.key }

            val tempCompare = firstCards[1].compareTo(secondCards[1])
            if (tempCompare != 0){
                return tempCompare
            }
            return firstCards[0].compareTo(secondCards[0])
        }

        private fun compareTwoStraight(first: Hand, second: Hand) = first.cards.maxOf { it.rank }.compareTo(second.cards.maxOf { it.rank })

        private fun compareTwoTwoPare(first: Hand, second: Hand): Int {
            val firstPares = first.cards.groupingBy { it.rank }.eachCount().filter { it.value == 2 }.map { it.key }.sortedDescending()
            val secondPares = second.cards.groupingBy { it.rank }.eachCount().filter { it.value == 2 }.map { it.key }.sortedDescending()

            var tempCompare = firstPares[0].compareTo(secondPares[0])
            if (tempCompare != 0){
                return tempCompare
            }

            tempCompare = firstPares[1].compareTo(secondPares[1])
            if (tempCompare != 0){
                return tempCompare
            }

            return compareTwoHighCard(first, second)
        }

        private fun compareTwoOnePare(first: Hand, second: Hand): Int {
            val firstPare = first.cards.groupingBy { it.rank }.eachCount().maxByOrNull { it.value }!!.key
            val secondPare = second.cards.groupingBy { it.rank }.eachCount().maxByOrNull { it.value }!!.key

            val tempCompare = firstPare.compareTo(secondPare)
            if (tempCompare != 0){
                return tempCompare
            }

            return compareTwoHighCard(first, second)
        }

        private fun compareTwoHighCard(first: Hand, second: Hand): Int {
            val firstCards = first.cards.sortedDescending()
            val secondCards = second.cards.sortedDescending()

            for ((index, card) in firstCards.withIndex()) {
                val temp = card.compareTo(secondCards[index])
                if (temp != 0) {
                    return temp
                }
            }
            return 0
        }
    }
}




