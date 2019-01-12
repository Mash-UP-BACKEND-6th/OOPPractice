import java.util.ArrayList;

public class Dealer extends Thread implements Person {
    boolean isEnd = false;
    int valueSum = 0;
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
    }

    void showHand(){
        System.out.println("# 현재 가지고 있는 카드");
        for(Card c : hand){
            System.out.println("# "+c.getNumber() +" "+ c.getShape());
        }
        System.out.println("# 현재 가치 총 합 : "+valueSum);
    }

    public void run(){
        synchronized (this){
            try {
                // 처음 두장 뽑기
                selectCard();
                Thread.sleep((int)(Math.random()*1000));
                selectCard();
                while(valueSum <= 16){
                    System.out.println("# 한 장 더 뽑겠습니다");
                    selectCard();
                }
                isEnd = true;
                notify();
            } catch (InterruptedException e) {
                System.out.println("***딜러가 종료됩니다.");
            }
        }




    }
}
