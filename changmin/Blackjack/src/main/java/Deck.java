import java.util.*;

public class Deck {
    private List<Card> cards;

    public Deck() {
       shuffle();
    }

    public Card draw() {
        Random random = new Random(System.currentTimeMillis());
        int next = random.nextInt(cards.size());
        return cards.remove(next);
    }

    public void shuffle() {
        cards = new LinkedList<Card>();
        for(Suit suit : Suit.values()) {
            init(suit);
        }
    }

    public int countCard() {
        return cards.size();
    }

    public void init(Suit suit) {
        cards.add(new Card(suit, "A", 1));

        for(int i = 2; i <= 10; ++i) {
            cards.add(new Card(suit, String.valueOf(i), i));
        }

        for(String value : new String[]{"J", "Q", "K"}) {
            cards.add(new Card(suit, value, 10));
        }
    }
}
