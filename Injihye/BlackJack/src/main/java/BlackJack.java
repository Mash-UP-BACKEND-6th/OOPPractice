import java.util.Scanner;
import java.util.Random;

public class BlackJack
{
    private enum CardMarked {HEARTS, SPADES, CLUBS, DIAMONDS}
    private enum CardNum {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    CardMarked mark;
    CardNum num;

    private int cardNum;
    private int cardMark;

    private int score;
    private int totalScore = 0;

    Random generator = new Random();

    public BlackJack(){ }


    public void generatorRandom()
    {
        cardMark = generator.nextInt(4); // 0~4
        cardNum = generator.nextInt(13)+1; // 1~13

    }//카드 점수

    public void cardMarked()
    {
        switch(cardMark){

            case 0:
                mark = CardMarked.CLUBS;
                break;

            case 1:
                mark = CardMarked.HEARTS;
                break;

            case 2:
                mark = CardMarked.DIAMONDS;
                break;

            case 3:
                mark = CardMarked.SPADES;
                break;


        }

        switch(cardNum){

            case 1:
                num = CardNum.ACE;
                score = 1;
                break;

            case 2:
                num = CardNum.TWO;
                score = cardNum;
                break;

            case 3:
                num = CardNum.THREE;
                score = cardNum;
                break;

            case 4:
                num = CardNum.FOUR;
                score = cardNum;
                break;

            case 5:
                num = CardNum.FIVE;
                score = cardNum;
                break;

            case 6:
                num = CardNum.SIX;
                score = cardNum;
                break;

            case 7:
                num = CardNum.SEVEN;
                score = cardNum;
                break;

            case 8:
                num = CardNum.EIGHT;
                score = cardNum;
                break;

            case 9:
                num = CardNum.NINE;
                score = cardNum;
                break;

            case 10:
                num = CardNum.TEN;
                score = cardNum;
                break;

            case 11:
                num = CardNum.JACK;
                score = 10;
                break;

            case 12:
                num = CardNum.QUEEN;
                score = 10;
                break;

            case 13:
                num = CardNum.KING;
                score = 10;
                break;

        }

    }

    public void setPoint()
    {
        totalScore = totalScore + score;
    }

    public int getPoint()
    {
        return totalScore;
    }

    public void display() {
        System.out.println(num + " of " + mark);
    }

}


