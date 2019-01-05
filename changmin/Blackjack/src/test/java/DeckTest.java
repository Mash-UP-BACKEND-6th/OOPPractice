import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    @Test
    public void testFirstDeck() {
        Deck deck = new Deck();
        Assert.assertEquals(52, deck.countCard());
    }

    @Test
    public void testDrawDeck() {
        Deck deck = new Deck();
        deck.draw();
        Assert.assertEquals(51, deck.countCard());
    }

}
