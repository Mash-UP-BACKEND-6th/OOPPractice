import calendar.*;
import org.junit.Test;

/**
 * Created by changmin on 2018. 12. 15..
 */

public class CalenderTest {
    @Test
    public void main() {
        for(int i = 1; i <= 12; ++i) {
            System.out.println(i);
            Calendar calendar = new Calendar();
            calendar.print(2018, i);
        }
    }
}
