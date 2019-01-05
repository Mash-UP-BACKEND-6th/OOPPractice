

public class Main {

    public static void main(String[] args) {
        String winner = "";

        Gamer gamer = new Gamer();
        Dealer dealer = new Dealer();

        gamer.start();
        dealer.start();

        synchronized(dealer){
            try {
                dealer.wait();
                if(dealer.valueSum > 21){
                    System.out.println("딜러가 졌습니다.");
                    winner="gamer";
                    dealer.showHand();
                    System.out.println(winner+"가 이겼습니다.");
                    gamer.showHand();
                    gamer.interrupt();
                    System.out.println("게임을 종료합니다.");
                }else{
                    System.out.println("딜러가 카드를 모두 뽑았습니다");
                }
;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized(gamer){
            try {
                gamer.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int gamerGap = 21-gamer.valueSum;
        int dealerGap = 21-dealer.valueSum;

        if(gamerGap > dealerGap ){
            winner = "Gamer";
        }else{
            winner = "Dealer";
        }

        System.out.println(winner+"가 이겼습니다.");

    }


}
