import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GamerTest {
    @Test
    public void testDraw() {
        Deck deck = new Deck();
        Player gamer = new Gamer(deck);
        Card card = gamer.draw();
        Assert.assertNotNull(card);
    }

    @Test
    public void testIsEnd() {
        Deck deck = new Deck();
        Player gamer = new Gamer(deck);
        Assert.assertFalse(gamer.isEnd());

        int maxCount = deck.countCard();
        for(int i = 0; i < maxCount; ++i) {
            gamer.draw();
        }

        Assert.assertTrue(gamer.isEnd());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOverDraw(){
        Deck deck = new Deck();
        Player gamer = new Gamer(deck);
        int maxCount = deck.countCard();
        for(int i = 0; i <= maxCount; ++i) {
            gamer.draw();
        }
    }

    @Test
    public void testGetScore() {
        Deck deck = mock(Deck.class);
        Player gamer = new Gamer(deck);
        when(deck.draw()).thenReturn(new Card(Suit.Diamond, "10", 10),
                                    new Card(Suit.Clover, "A",1));
        gamer.draw();
        gamer.draw();
        Assert.assertEquals(11, gamer.getScore());

    }
}
