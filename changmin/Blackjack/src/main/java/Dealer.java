import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {
    private Deck deck;
    private List<Card> cards;
    private int score;

    public Dealer(Deck deck) {
        this.deck = deck;
        cards = new ArrayList<>();
        score = 0;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public Card draw() {
        Card card = deck.draw();
        cards.add(card);
        score += card.getScore();
        return card;
    }

    @Override
    public boolean isEnd() {
        return 16 < score;
    }
}
