package org.pokercardpatterndectector;

public class PokerCardController {
  public static void main(String[] args) {
    Deck deck = Deck.create();
    Card[] cards = new Card[5];

    int player = 10;

    for (int j = 0; j < player; j++) {
      for (int i = 0; i < cards.length; i++) {
        deck.shuffle();
        cards[i] = deck.deal();
        System.out.println(cards[i]);
      }

      PatternDetector detector = new PatternDetector(cards);

      CardPattern pattern = detector.detect(cards);
      System.out.println("=".repeat(10));
      System.out.println(pattern);
      System.out.println("=".repeat(30));
    }
  }
}
