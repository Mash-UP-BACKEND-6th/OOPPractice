import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

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

    //상품 추가 및 확인
    @Test
    public void test_addProduct() {
        Product test = new Product("test","test",0,0, new Date(System.currentTimeMillis()));
        vendingMachine.addStock(test);
        List<Product> productList = vendingMachine.getProductList();
        Assert.assertEquals(test, productList.get(0));
    }

    // 상품 구매하기
    @Test
    public void test_buyProduct() {

    }

}
