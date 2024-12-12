package PokerGame.Enums;

public enum Suit {
    HEART('♥'), TILE('♦'), CLOVER('♣'), PIKE('♠');

    final Character suitLogo;
    Suit(Character suitLogo) {
        this.suitLogo = suitLogo;
    }

    @Override
    public String toString() {
        return suitLogo.toString();
    }
}
