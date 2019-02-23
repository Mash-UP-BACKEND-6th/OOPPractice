import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine{
    private int insertedMoney;
    List<ProductInfo> productInfos = new ArrayList<>();
    Map<ProductInfo, Integer> stock = new HashMap<>();

    @Override
    public void insertMoney(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("No minus money! " + money);
        }
        this.insertedMoney = money;
    }

    @Override
    public void addStock(Product product) {
        ProductInfo productInfo = new ProductInfo(product);
        if (stock.containsKey(productInfo)) {
            stock.put(productInfo, stock.get(productInfo) + 1);
        } else {
            stock.put(productInfo, 1);
            productInfos.add(productInfo);
        }
    }

    @Override
    public List<ProductInfo> getProductList() {
        List<ProductInfo> possibles = new ArrayList<>();
        for (ProductInfo productInfo : productInfos) {
            if(productInfo.getPrice() <= insertedMoney) {
                possibles.add(productInfo);
            }
        }
        return possibles;
    }

    @Override
    public void buy(ProductInfo productInfo) {

    }

    @Override
    public int getInsertedMoney() {
        return insertedMoney;
    }

    @Override
    public Map<ProductInfo, Integer> getStocks() {
        return null;
    }

    @Override
    public List<Record> getRecords() {
        return null;
    }
}
