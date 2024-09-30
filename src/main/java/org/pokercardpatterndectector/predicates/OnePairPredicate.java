package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public class OnePairPredicate implements PatternPredicate {

  @Override
  public boolean detect(PatternDetector p) {

    for (int count : p.getRank().values()) {
      if (count >= 2) {
        return true;
      }
    }

    return false;
  }

  @Override
  public CardPattern getPattern() {
    return CardPattern.ONE_PAIR;
  }
}
