

public class Main {

    public static void main(String[] args) {
        String winner = "";
        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        dealer.start();
        gamer.start();

        while(gamer.isAlive()){
            synchronized(dealer){
                try {
                    dealer.wait();
                    if(dealer.valueSum > 21){
                        dealer.isEnd= true;
                        break;
                    }else{
                        System.out.println("딜러가 카드를 모두 뽑았습니다");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized(gamer){
                try {
                    gamer.wait();
                    if(gamer.valueSum > 21){
                        gamer.isEnd=true;
                        break;
                    }else{
                        System.out.println("게이머가 카드를 모두 뽑았습니다");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        gamer.interrupt();
        dealer.interrupt();
        System.out.println("카드를 오픈합니다.");
        System.out.println("게이머===========");
        gamer.showHand();
        System.out.println("딜러===========");
        dealer.showHand();

        if(gamer.isEnd == true){
            System.out.println("게이머의 카드 가치 합이 21을 초과하였습니다.");
            winner="Dealer";
        }else if(dealer.isEnd == true){
            System.out.println("딜러의 카드 가치 합이 21을 초과하였습니다.");
            gamer.interrupt();
            winner="Gamer";
        }else{
            int gamerGap = 21-gamer.valueSum;
            int dealerGap = 21-dealer.valueSum;

            if(gamerGap < dealerGap ){
                winner = "Gamer";
            }else{
                winner = "Dealer";
            }
        }
        System.out.println("======결   과======");
        System.out.println(winner+"가 이겼습니다.");
        System.out.println("게임을 종료합니다.");

    }


}
