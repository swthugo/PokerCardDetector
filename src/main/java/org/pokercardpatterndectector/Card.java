package org.pokercardpatterndectector;

import java.util.Objects;


public final class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;

    private Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card of(Suit suit, Rank rank) {
        return new Card(suit, rank);
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", rank=" + rank + '}';
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(Card o) {
        if (suit.value != o.suit.value) {
            return suit.value - o.suit.value;
        }
        return (rank.value - 1) % 13 - (o.rank.value - 1) % 13;
    }

    public enum Suit {
        SPADE(4),
        HEART(3),
        CLUB(2),
        DIAMOND(1);

        private final int value;

        Suit(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
