import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Drawer {
    private List<Integer> list;
    private Random rand;

    public Drawer() {
        rand = new Random(System.currentTimeMillis());
        init();
    }

    public void init() {
        list = new LinkedList<>();
        for(int i = 1; i < 10; ++i) {
            list.add(i);
        }
    }

    public List<Integer> drawAnswer() {
        init();

        List<Integer> answer = new LinkedList<>();

        for(int i = 0; i < 3; ++i) {
            answer.add(drawNumber());
        }

        return answer;
    }

    public int drawNumber() {
        int index = rand.nextInt(list.size());
        return list.remove(index);
    }
}
