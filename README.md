# Poker Card Detector


## Introduction

The **Poker Card Detector** is a Java application designed to identify poker hand patterns from a set of dealt cards. This project allows users to test and interact with different poker hands, providing insights into the patterns found in the cards.

## How It Works

The application simulates a poker game by shuffling a deck of cards and dealing a hand of five cards. It utilizes the `PatternDetector` class to analyze the hand and determine the poker hand pattern.

### Entry Point

The entry point for the application is the `PokerCardController` class. Users can run the application to test various hands and see the detected patterns.

### Example Code

Here's a brief overview of how the main functionality is implemented:

```java
public static void main(String[] args) {
    Deck deck = Deck.create();
    Card[] cards = new Card[5];

    int player = 10;

    for (int j = 0; j < player; j++) {
        for (int i = 0; i < cards.length; i++) {
            deck.shuffle();
            cards[i] = deck.deal();
            System.out.println(cards[i]);
        }

        PatternDetector detector = new PatternDetector(cards);
        CardPattern pattern = detector.detect(cards);
        System.out.println("=".repeat(10));
        System.out.println(pattern);
        System.out.println("=".repeat(30));
    }
}
```


### Pattern Detection
The PatternDetector class employs a series of predicates to evaluate the hand against various poker patterns, such as:

```java
public class PatternDetector {
    private final PatternPredicate[] predicates = {
        new RoyalFlush(),
        new StraightFlush(),
        new FourOfAKind(),
        new FullHouse(),
        new Flush(),
        new Straight(),
        new ThreeOfAKind(),
        new TwoPairsPredicate(),
        new OnePairPredicate()
    };
}
```

## Getting Started
1. **Clone the repository:**
```
git clone https://github.com/yourusername/poker-card-detector.git
```

2. **Navigate to the project directory:**
```
cd poker-card-detector
```

3. **Open the project in IntelliJ IDEA:**
   - It is strongly recommended to try this project in IntelliJ IDEA.

4. **Compile and run the application:**
Ensure you have Java installed and run:
```
javac PokerCardController.java
java PokerCardController
```

## Contributing
Feel free to fork the repository and submit pull requests. Contributions are welcome!