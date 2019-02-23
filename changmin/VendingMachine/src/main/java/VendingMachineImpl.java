import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine{
    private int insertedMoney;
    List<Product> products = new ArrayList<>();
    Map<Product, Integer> stock = new HashMap<>();

    @Override
    public void insertMoney(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("No minus money! " + money);
        }
        this.insertedMoney = money;
    }

    @Override
    public void addStock(Product product) {
        if (stock.containsKey(product)) {
            stock.put(product, stock.get(product) + 1);
        } else {
            stock.put(product, 1);
            products.add(product);
        }
    }

    @Override
    public List<Product> getProductList() {
        List<Product> possibles = new ArrayList<>();
        for (Product product : products) {
            if(product.getPrice() <= insertedMoney) {
                possibles.add(product);
            }
        }
        return possibles;
    }

    @Override
    public void buy(Product product) {

    }

    @Override
    public int getInsertedMoney() {
        return insertedMoney;
    }

    @Override
    public Map<Product, Integer> getStocks() {
        return null;
    }

    @Override
    public List<Record> getRecords() {
        return null;
    }
}
