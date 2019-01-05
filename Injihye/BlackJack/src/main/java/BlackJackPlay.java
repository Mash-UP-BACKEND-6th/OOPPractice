
import java.util.Scanner;

public class BlackJackPlay
{

    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);

        BlackJack player = new BlackJack();
        BlackJack dealer = new BlackJack();

        System.out.println("player의 카드");
        player.generatorRandom();
        player.cardMarked();
        player.setPoint();
        player.display();
        player.generatorRandom();
        player.cardMarked();
        player.setPoint();
        player.display();

        System.out.println("player의 점수는 " + player.getPoint());
        System.out.println("카드 한 장 더?(yes/no):");
        String userType = sc.nextLine();
        userType.toLowerCase();



        while(userType.equals("yes") && (player.getPoint() <= 21)){
            player.generatorRandom();
            player.cardMarked();
            player.setPoint();
            player.display();
            System.out.println("player의 점수는 " + player.getPoint());
            System.out.println("카드 한 장 더? (yes/no):");
            userType = sc.nextLine();
        }

        if(player.getPoint() > 21) {
            System.out.println("21점이 넘어 게임 끝"); }



        else {
            System.out.println("player의 점수는 : " + player.getPoint());

            System.out.println("딜러가 가진 카드 ");
            dealer.generatorRandom();
            dealer.cardMarked();
            dealer.setPoint();
            dealer.display();
            dealer.generatorRandom();
            dealer.cardMarked();
            dealer.setPoint();
            dealer.display();
            System.out.println("Dealer의 점수는 : " + dealer.getPoint());

            while(dealer.getPoint() <=14) {

                dealer.generatorRandom();
                dealer.cardMarked();
                dealer.setPoint();
                System.out.println("The dealer got the ");
                dealer.display();
                System.out.println("dealer의 점수는 " + dealer.getPoint());
            }

            if(dealer.getPoint() > 21)
                System.out.println("dealer가 21점이 넘어 게임 끝.\n player의 승리!");





        }

        if ((dealer.getPoint())<=21 && (player.getPoint()<= 21))
        { if (player.getPoint() > dealer.getPoint())
            System.out.println("player wins");
        else if (player.getPoint() < dealer.getPoint())
            System.out.println("dealer wins");
        else System.out.println("draw");

        }


    }//end main


}// end class
