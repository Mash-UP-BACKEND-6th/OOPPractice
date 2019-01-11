import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DrawerTest {
    @Test
    public void testDraw() {
        Drawer drawer = new Drawer();
        Set<Integer> resultSet = new HashSet<>();

        for(int i = 1; i < 10; ++i) {
            int number = drawer.drawNumber();
            Assert.assertFalse(resultSet.contains(number));
            resultSet.add(number);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testManyDraw() {
        Drawer drawer = new Drawer();
        Set<Integer> resultSet = new HashSet<>();

        for(int i = 0; i < 20; ++i) {
            int number = drawer.drawNumber();
            Assert.assertFalse(resultSet.contains(number));
        }
    }
}
