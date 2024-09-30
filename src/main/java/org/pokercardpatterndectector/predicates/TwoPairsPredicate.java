package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public class TwoPairsPredicate implements PatternPredicate {

  @Override
  public boolean detect(PatternDetector p) {

    int numPair = 0;

    for (int count : p.getRank().values()) {
      if (count >= 2) {
        numPair++;
      }
    }

    return numPair >= 2;
  }

  @Override
  public CardPattern getPattern() {
    return CardPattern.TWO_PAIRS;
  }
}
