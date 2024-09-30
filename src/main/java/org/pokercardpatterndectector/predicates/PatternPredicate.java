package org.pokercardpatterndectector.predicates;

import org.pokercardpatterndectector.CardPattern;
import org.pokercardpatterndectector.PatternDetector;

public interface PatternPredicate {

    boolean detect(PatternDetector p);

    CardPattern getPattern();

}
