import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Drawer {
    List<Integer> numbers;
    Random random;
    public Drawer() {
        init();
    }

    public void init() {
        random = new Random(System.currentTimeMillis());
        numbers = new LinkedList<>();

        for (int i = 1; i <= 45; ++i) {
            numbers.add(i);
        }
    }

    public int draw() {
        if(numbers.size() == 1) {
            return numbers.remove(0);
        }

        int selected = random.nextInt(numbers.size() -1);

        return numbers.remove(selected);
    }

    public List<Integer> draw(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            list.add(draw());
        }

        return list;
    }
}
