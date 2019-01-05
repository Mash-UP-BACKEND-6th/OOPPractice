import java.util.Scanner;

public class BlackJack {
    public void play() {
        Deck deck = new Deck();
        Player dealer = new Dealer(deck);
        Player gamer = new Gamer(deck);


        Card card = dealer.draw();
        System.out.println("딜러가 카드를 뽑았습니다." + card);
        card = gamer.draw();
        System.out.println("게이머가 카드를 뽑았습니다." + card);
        card = dealer.draw();
        System.out.println("딜러가 카드를 뽑았습니다." + card);
        card = gamer.draw();
        System.out.println("게이머가 카드를 뽑았습니다." + card);

        while (!dealer.isEnd()) {
            card = dealer.draw();
            System.out.println("딜러가 카드를 뽑았습니다." + card);
        }

        while (isContinue(gamer) && !gamer.isEnd()) {
            card = gamer.draw();
            System.out.println("게이머가 카드를 뽑았습니다." + card);
        }

        int blackjack = 21;
        if (Math.abs(blackjack - dealer.getScore()) > Math.abs(blackjack - gamer.getScore())) {
            System.out.println("딜러가 이겼습니다.");
        } else {
            System.out.println("게이머가 이겼습니다.");
        }
    }

    private boolean isContinue(Player gamer) {
        Scanner scanner = new Scanner(System.in);
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
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }
}
