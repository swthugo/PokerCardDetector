package org.pokercardpatterndectector;

import java.util.*;


public class Deck {

    public static final int DEFAULT_DECK_SIZE = 52;

    private static final Comparator<Card> DEFAULT_CARD_ORDER = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            return o1.compareTo(o2);
        }
    };

    private List<Card> cards;

    private Deck(List<Card> cards) {
        this.cards = cards;
    }

    public static Deck create() {
        List<Card> c = new ArrayList<>();

        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Rank r : Card.Rank.values()) {
                c.add(Card.of(s, r));
            }
        }

        c.sort(cardComparator());
        return new Deck(c);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void reset(){
        cards.sort(cardComparator());
    }

    public Card deal(){
        // Throw EmptyDeckException if the deck is empty
        if (cards.isEmpty()) {
            throw new EmptyDeckException("The deck is empty.");
        }

        return cards.removeFirst();
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public int size(){
        return cards.size();
    }

    public boolean contains(Card card){
        return cards.contains(card);
    }

    protected List<Card> getCards() {
        return cards;
    }

    protected void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cards);
    }

    public static Comparator<Card> cardComparator() {
        return Comparator.comparing(Card::getSuit).thenComparing(c -> c);
    }
}

