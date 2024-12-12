package PokerGame.Enums;

public enum CardValue {
    Nine(1, "9"),
    Ten(2, "10"),
    Jack(3, "J"),
    Queen(4, "Q"),
    King(5, "K"),
    Ace(6, "A");

    private final int weight;
    private final String description;

    CardValue(int weight, String description) {
        this.weight = weight;
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return description;
    }
}
