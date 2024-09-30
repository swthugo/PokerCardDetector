package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public class ThreeOfAKind implements PatternPredicate {

  @Override
  public boolean detect(PatternDetector p) {

    for (int count : p.getRank().values()) {
      if (count >= 3) {
        return true;
      }
    }

    return false;
  }

  @Override
  public CardPattern getPattern() {
    return CardPattern.THREE_OF_A_KIND;
  }
}
