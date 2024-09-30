package org.pokercardpatterndectector;

import org.pokercardpatterndectector.predicates.*;

import java.util.*;

public class PatternDetector {

  private final PatternPredicate[] predicates = {
          new RoyalFlush(),
          new StraightFlush(),
          new FourOfAKind(),
          new FullHouse(),
          new Flush(),
          new Straight(),
          new ThreeOfAKind(),
          new TwoPairsPredicate(),
          new OnePairPredicate()};

  boolean isFlush;
  boolean isStraight;
  boolean hasAce;
  Map<Card.Rank, Integer> rank;
  Map<Card.Suit, Integer> suit;

  public PatternDetector(Card[] cards) {

    rank = new HashMap<>();
    suit = new HashMap<>();

    for (Card card : cards) {
      rank.put(card.getRank(), rank.getOrDefault(card.getRank(), 0) + 1);
      suit.put(card.getSuit(), suit.getOrDefault(card.getSuit(), 0) + 1);
    }

    this.isFlush = checkFlush(suit);
    this.isStraight = checkStraight(rank);
    this.hasAce = rank.containsKey(Card.Rank.ACE);
  }

  public static boolean checkFlush(Map<Card.Suit, Integer> suit) {

    boolean isFlush = false;

    for (int count : suit.values()) {
      if (count >= 5) {
        isFlush = true;
        break;
      }
    }

    return isFlush;
  }

  public static boolean checkStraight(Map<Card.Rank, Integer> rank) {

    if (rank.size() < 5) {
      return false;
    }

    Collection<Card.Rank> values = rank.keySet();
    Card.Rank[] sortedRank = values.toArray(new Card.Rank[0]);
    Arrays.sort(sortedRank);

    Set<Card.Rank> specialCase = new HashSet<>() {{
      add(Card.Rank.ACE);
      add(Card.Rank.TWO);
      add(Card.Rank.THREE);
      add(Card.Rank.FOUR);
      add(Card.Rank.FIVE);
    }};

    int countSpecialCase = 0;
    for (Card.Rank n : rank.keySet()) {
      if (specialCase.contains(n)) {
        countSpecialCase++;
      }
    }

    if (countSpecialCase >= 5) {
      return true;
    }

    int continuousNumber = 1;
    for (int i = 0; i < sortedRank.length - 1; i++) {

      if (sortedRank[i].getValue() + 1 == sortedRank[i + 1].getValue()) {
        continuousNumber++;
      } else {
        continuousNumber = 1;
      }

      if (continuousNumber > 4) {
        return true;
      }
    }

    return false;
  }

  public boolean getIsFlush() {
    return isFlush;
  }

  public boolean getIsStraight() {
    return isStraight;
  }

  public boolean getHasAce() {
    return hasAce;
  }

  public Map<Card.Rank, Integer> getRank() {
    return rank;
  }

  public CardPattern detect(Card[] cards) {
    PatternDetector pattern = new PatternDetector(cards);

    for (PatternPredicate predicate : predicates) {
      if (predicate.detect(pattern)) {
        return predicate.getPattern();
      }
    }
    return CardPattern.HIGH_CARD;
  }
}

