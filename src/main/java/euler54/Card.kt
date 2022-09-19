package euler54

data class Card(val rank: Rank, val suit: Suit) : Comparable<Card> {

    constructor(card: String) : this(Rank.valueOf(card[0]), Suit.valueOf(card[1]))

    override fun compareTo(other: Card): Int = this.rank.compareTo(other.rank)
}

enum class Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    companion object {
        fun valueOf(value: Char): Rank = when (value) {
            'A' -> ACE
            'K' -> KING
            'Q' -> QUEEN
            'J' -> JACK
            'T' -> TEN
            '9' -> NINE
            '8' -> EIGHT
            '7' -> SEVEN
            '6' -> SIX
            '5' -> FIVE
            '4' -> FOUR
            '3' -> THREE
            '2' -> TWO
            else -> throw IllegalArgumentException()
        }
    }
}

enum class Suit {
    HEART, SPADE, DIAMOND, CLUB;

    companion object {
        fun valueOf(value: Char): Suit = when (value) {
            'H' -> HEART
            'S' -> SPADE
            'D' -> DIAMOND
            'C' -> CLUB
            else -> throw IllegalArgumentException()
        }
    }
}

