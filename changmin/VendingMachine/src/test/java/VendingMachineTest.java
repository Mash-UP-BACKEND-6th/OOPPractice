import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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
        Product test1 = new Product("test","test",0,0, new Date(System.currentTimeMillis()));
        Product test2 = new Product("test","test",0,0, new Date(System.currentTimeMillis()));

        vendingMachine.addStock(test1);
        vendingMachine.addStock(test2);
        List<ProductInfo> productInfoList = vendingMachine.getProductList();
        Assert.assertEquals(new ProductInfo(test1), productInfoList.get(0));
    }

    // 상품 구매하기
    @Test
    public void test_buyProduct() {
        Product test = new Product("test","test",0,0, new Date(System.currentTimeMillis()));
        vendingMachine.addStock(test);
        Product result = vendingMachine.buy(new ProductInfo(test));
        Assert.assertEquals(test, result);
    }

    // 전체 상품 재고 확인
    @Test
    public void test_getStocks() {
        Product p1_1 = new Product("test1","test",0,0, new Date(System.currentTimeMillis()));
        Product p1_2 = new Product("test1","test",0,0, new Date(System.currentTimeMillis()));
        Product p2_1 = new Product("test2","test",0,0, new Date(System.currentTimeMillis()));

        vendingMachine.addStock(p1_1);
        vendingMachine.addStock(p1_2);
        vendingMachine.addStock(p2_1);

        Map<ProductInfo, Integer> stockInfo =  vendingMachine.getStocks();
        Assert.assertEquals(new Integer(2), stockInfo.get(new ProductInfo(p1_1)));
        Assert.assertEquals(new Integer(1), stockInfo.get(new ProductInfo(p2_1)));
    }

}
