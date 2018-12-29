import org.junit.Assert;
import org.junit.Test;

public class TestDrawingMachine {

    @Test
    public void testManypeople() {
        int people = 10;
        int lose = 6;
        DrawingMachine drawingMachine = new DrawingMachine();
        drawingMachine.shuffle(people, lose);
        int counter = 0;
        for (int i = 1; i <= 10; ++i) {
            if (drawingMachine.check(i)) {
                counter += 1;
            }
        }
        Assert.assertEquals(people - lose, counter);
    }
}
