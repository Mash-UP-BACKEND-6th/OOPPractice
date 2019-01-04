public class Card {
    Suit suite;
    String value;
    int score;

    public Card(Suit suite, String value, int score) {
        this.suite = suite;
        this.value = value;
        this.score = score;
    }

    public Suit getSuite() {
        return suite;
    }

    public String getValue() {
        return value;
    }

    public int getScore() {
        return score;
    }
}
