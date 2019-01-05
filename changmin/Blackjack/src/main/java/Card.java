public class Card {
    private Suit suite;
    private String value;
    private int score;

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

    @Override
    public String toString() {
        return "[" + suite +
                " " + value + " ("+ score + ") ]";
    }
}
