import java.io.InputStream;
import java.util.Scanner;

public class BlackJack {
    private static final int BLACKJACK = 21;
    public static final int GAMEOVER = Integer.MAX_VALUE;
    public enum Result{WIN, LOSE, DRAW};

    private Player dealer;
    private Player gamer;
    Scanner scanner;

    public BlackJack(Player dealer, Player gamer, InputStream inputStream) {
        this.dealer = dealer;
        this.gamer = gamer;
        this.scanner = new Scanner(inputStream);
    }

    public Result play() {
        dealer.draw();
        System.out.println("딜러가 카드를 뽑았습니다.");

        Card card = gamer.draw();
        System.out.println("게이머가 카드를 뽑았습니다." + card);

        dealer.draw();
        System.out.println("딜러가 카드를 뽑았습니다.");

        card = gamer.draw();
        System.out.println("게이머가 카드를 뽑았습니다." + card);

        while (!dealer.isEnd()) {
            dealer.draw();
            System.out.println("딜러가 카드를 뽑았습니다.");
        }

        while (isContinue() && !gamer.isEnd()) {
            card = gamer.draw();
            System.out.println("게이머가 카드를 뽑았습니다." + card);
        }

        System.out.println(String.format("딜러 점수 :%s, 게이머 점수 : %s",
                                            dealer.getScore(), gamer.getScore()));
        int dealerScore = getDistanceBlackjack(dealer);
        int gamerScore = getDistanceBlackjack(gamer);

        if (dealerScore > gamerScore) {
            System.out.println("게이머가 이겼습니다.");
            return Result.WIN;
        } else if(dealerScore < gamerScore) {
            System.out.println("딜러가 이겼습니다.");
            return Result.LOSE;
        } else {
            System.out.println("무승부!");
            return Result.DRAW;
        }

    }

    public int getDistanceBlackjack(Player player) {
        int finalScore = BLACKJACK - player.getScore();
        if (0 == finalScore) {
            System.out.println("Black jack!");
        }
        if (0 > finalScore) {
            System.out.println("Game Over!");
            finalScore = GAMEOVER;
        }

        return finalScore;
    }

    public boolean isContinue() {
        do {
            System.out.println("계속 뽑으시겠습니까?(y/n)");
            String answer = scanner.nextLine();
            if ("y".equals(answer)) {
                return true;
            } else if ("n".equals(answer)) {
                return false;
            } else {
                System.out.println("y/n 중에 하나를 입력하세요.");
            }
        } while(true);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Player dealer = new Dealer(deck);
        Player gamer = new Gamer(deck);
        BlackJack blackJack = new BlackJack(dealer, gamer, System.in);
        blackJack.play();
    }
}
