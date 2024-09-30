package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public class Flush implements PatternPredicate {

  @Override
  public boolean detect(PatternDetector p) {
    return p.getIsFlush();
  }

  @Override
  public CardPattern getPattern() {
    return CardPattern.FLUSH;
  }
}
