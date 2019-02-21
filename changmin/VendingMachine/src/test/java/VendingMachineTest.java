import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
    VendingMachine vendingMachine;

    @Before
    public void init() {
        vendingMachine = new VendingMachineImpl();
    }

    @Test
    public void test_insertMoney() {
        int money = 10000;
        vendingMachine.insertMoney(money);
        Assert.assertEquals(money, vendingMachine.getInsertedMoney());
    }
    //Integer.MAX_VALUE + 1 같은것도 여기서 처리 가능
    @Test(expected = IllegalArgumentException.class)
    public void test_insertMinusMoney() {
        int money = - 1000;
        vendingMachine.insertMoney(money);
    }

}
