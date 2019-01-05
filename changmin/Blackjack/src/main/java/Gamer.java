import java.util.ArrayList;
import java.util.List;

public class Gamer implements Player{
    private Deck deck;
    private int score;
    private List<Card> cards;

    public Gamer(Deck deck) {
        this.deck = deck;
        cards = new ArrayList<>();
        score = 0;
    }

    @Override
    public Card draw() {
        Card card = deck.draw();
        cards.add(card);
        score += card.getScore();
        return deck.draw();
    }

    @Override
    public boolean isEnd() {
        //덱이 없을때 -> 여기서 해결
        //종료 했을때 -> 외부에서 해결
        return deck.countCard() == 0;
    }

    @Override
    public int getScore() {
        return score;
    }
}
