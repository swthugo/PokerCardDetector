package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public class FourOfAKind implements PatternPredicate {

  @Override
  public boolean detect(PatternDetector p) {

    for (int count : p.getRank().values()) {
      if (count >= 4) {
        return true;
      }
    }

    return false;
  }

  @Override
  public CardPattern getPattern() {
    return CardPattern.FOUR_OF_A_KIND;
  }
}
