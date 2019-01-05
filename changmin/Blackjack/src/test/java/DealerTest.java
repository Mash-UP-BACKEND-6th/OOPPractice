import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DealerTest {
    static Set<String> valueSet = new HashSet<>();
    static {
        for (int i = 2; i <= 10; ++i) {
            valueSet.add(String.valueOf(i));
        }

        for (String value : new String[]{"A", "J", "Q", "K"}) {
            valueSet.add(value);
        }
    }

    @Test
    public void testDraw() {
        Deck deck = new Deck();
        Player dealer = new Dealer(deck);
        Card card = dealer.draw();
        Assert.assertNotNull(card);
        Assert.assertTrue(isValidCard(card));
    }

    @Test
    public void testIsEnd() {
        Deck deck = mock(Deck.class);
        Player dealer = new Dealer(deck);
        Assert.assertFalse(dealer.isEnd());

        when(deck.draw()).thenReturn(new Card(Suit.Clover, "J", 10),
                                    new Card(Suit.Diamond, "J", 10));
        dealer.draw();
        dealer.draw();
        Assert.assertTrue(dealer.isEnd());
    }

    public boolean isValidScore(Card card) {
        return card.getScore() > 0 && card.getScore() <= 10;
    }

    public boolean isValidSuit(Card card) {
        for(Suit suit : Suit.values()) {
            if (suit == card.getSuite()) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidCard(Card card) {
        return isValidScore(card) && isValidSuit(card)  && isValidValue(card);
    }

    private boolean isValidValue(Card card) {
        return valueSet.contains(card.getValue());
    }


}
