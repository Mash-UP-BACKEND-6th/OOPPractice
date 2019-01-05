import java.util.ArrayList;
import java.util.Scanner;

public class Gamer extends Thread implements Person {
    int valueSum = 0;
    Scanner scanner = new Scanner(System.in);
    boolean isEnd = false;
    ArrayList<Card> hand = new ArrayList<>();

    void selectCard(){
        hand.add(new Card(random.nextInt(CARD_NUMBER)+1,random.nextInt(CARD_SHAPE)+1));
        updateValue();
        showHand();
    }

    void updateValue(){
        int valueNow = 0;
        for(Card c : hand){
            valueNow += c.value;
        }
        valueSum = valueNow;

        if(valueSum >21){

        }
    }

    void showHand(){
        System.out.println("||||| 현재 가지고 있는 카드");
        for(Card c : hand){
            System.out.println("||||| "+c.getNumber() +" "+ c.getShape());
        }
        System.out.println("||||| 현재 가치 총 합 : "+valueSum);
    }

    public void run(){
        try {
            // 처음 두장 뽑기
            selectCard();
            Thread.sleep((int)(Math.random()*1000));
            selectCard();

            synchronized (this){
                while(valueSum<=21){
                    System.out.println("||||| 카드를 더 뽑으시겠습니까? y or n");
                    String continuE = scanner.next();
                    if(continuE.equals("n")){
                        break;
                    }else{
                        System.out.println("||||| 한장 더 뽑겠습니다.");
                        selectCard();
                    }
                    notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("***게이머가 종료됩니다.");
        }
    }

}

