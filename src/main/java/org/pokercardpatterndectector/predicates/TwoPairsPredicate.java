package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.Card;
import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

import java.util.HashMap;
import java.util.Map;

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
