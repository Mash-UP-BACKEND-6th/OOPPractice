import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlackJackTest {
    private Player dealer;
    private Player gamer;

    @Before
    public void before() {
        dealer = mock(Dealer.class);
        gamer = mock(Gamer.class);
    }

    @Test
    public void testGamerOver() {
        when(dealer.getScore()).thenReturn(20);
        when(dealer.isEnd()).thenReturn(false, true);

        when(gamer.getScore()).thenReturn(22);
        InputStream inputStream = new ByteArrayInputStream("n\n".getBytes());

        BlackJack blackJack = new BlackJack(dealer, gamer, inputStream);
        Assert.assertEquals(BlackJack.Result.LOSE, blackJack.play());
    }

    @Test
    public void testDealerOver() {
        when(dealer.getScore()).thenReturn(22);
        when(dealer.isEnd()).thenReturn(false, true);

        when(gamer.getScore()).thenReturn(21);
        InputStream inputStream = new ByteArrayInputStream("n\n".getBytes());

        BlackJack blackJack = new BlackJack(dealer, gamer, inputStream);
        Assert.assertEquals(BlackJack.Result.WIN, blackJack.play());
    }

    @Test
    public void testOverDraw() {
        when(dealer.getScore()).thenReturn(22);
        when(dealer.isEnd()).thenReturn(false, true);

        when(gamer.getScore()).thenReturn(22);
        InputStream inputStream = new ByteArrayInputStream("n\n".getBytes());

        BlackJack blackJack = new BlackJack(dealer, gamer, inputStream);
        Assert.assertEquals(BlackJack.Result.DRAW, blackJack.play());
    }

    @Test
    public void testGameOver() {
        when(dealer.getScore()).thenReturn(23);
        when(gamer.getScore()).thenReturn(23);
        InputStream inputStream = mock(InputStream.class);
        BlackJack blackJack = new BlackJack(dealer, gamer, inputStream);
        Assert.assertEquals(BlackJack.GAMEOVER, blackJack.getDistanceBlackjack(dealer));
        Assert.assertEquals(BlackJack.GAMEOVER, blackJack.getDistanceBlackjack(gamer));
    }

    @Test
    public void testBlackJack() {
        when(dealer.getScore()).thenReturn(21);
        when(gamer.getScore()).thenReturn(21);
        InputStream inputStream = mock(InputStream.class);
        BlackJack blackJack = new BlackJack(dealer, gamer, inputStream);
        Assert.assertEquals(0, blackJack.getDistanceBlackjack(dealer));
        Assert.assertEquals(0, blackJack.getDistanceBlackjack(gamer));
    }

    @Test
    public void testContiniue() {
        InputStream inputStream = new ByteArrayInputStream("y\nn\n".getBytes());
        BlackJack blackJack = new BlackJack(dealer, gamer, inputStream);
        Assert.assertEquals(blackJack.isContinue(), true);
        Assert.assertEquals(blackJack.isContinue(), false);
    }
}
