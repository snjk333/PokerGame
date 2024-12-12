package PokerGame.Enums;

public enum Combination {
    HighCard(1),
    Pair(2),
    TwoPairs(3),
    ThreeOfKind(4),
    Straight(5),
    Flush(6),
    FullHouse(7),
    FourOfKind(8),
    StraightFlush(9),
    RoyalFlash(10);

    private final int weight;
    public int getWeight() {
        return weight;
    }
    Combination(int weight) {
        this.weight = weight;
    }
}
