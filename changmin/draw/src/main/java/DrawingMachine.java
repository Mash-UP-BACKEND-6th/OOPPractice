import java.util.*;

public class DrawingMachine {
    private List<Integer> lot;
    public void shuffle(int people, int lose) {
        lot = new LinkedList<Integer>();

        for(int i = 0; i < people; ++i) {
            lot.add(i);
        }

        Random random = new Random();
        for(int i = 0; i < lose; ++i) {
            int loser = random.nextInt(lot.size());
            lot.remove(loser);
        }
    }

    public boolean check(int number) {
        number -= 1; //인덱스를 맞춘다.
        return lot.contains(number);
    }
}
