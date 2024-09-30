package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public class StraightFlush implements PatternPredicate {

  @Override
  public boolean detect(PatternDetector p) {
    return p.getIsStraight() && p.getIsFlush();
  }

  @Override
  public CardPattern getPattern() {
    return CardPattern.STRAIGHT_FLUSH;
  }
}
