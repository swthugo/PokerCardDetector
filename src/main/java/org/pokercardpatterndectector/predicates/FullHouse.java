package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public class FullHouse implements PatternPredicate {

  @Override
  public boolean detect(PatternDetector p) {

    int numThreeOFAKind = 0;
    int numParis = 0;

    for (int count : p.getRank().values()) {
      if (count >= 2) {
        numParis++;
      }
      if (count >= 3) {
        numThreeOFAKind++;
      }
    }

    return numThreeOFAKind >= 1 && numParis >= 2;
  }

  @Override
  public CardPattern getPattern() {
    return CardPattern.FULL_HOUSE;
  }
}
