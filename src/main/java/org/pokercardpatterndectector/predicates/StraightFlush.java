package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.Card;
import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

import java.util.Map;

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
