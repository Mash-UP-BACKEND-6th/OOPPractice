import java.util.List;

public class VendingMachineImpl implements VendingMachine{
    private int insertedMoney;

    @Override
    public void insertMoney(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("No minus money! " + money);
        }
        this.insertedMoney = money;
    }

    @Override
    public void addStock(Product product) {

    }

    @Override
    public List<Product> getProductList() {
        return null;
    }

    @Override
    public void buy(Product product) {

    }

    @Override
    public int getInsertedMoney() {
        return insertedMoney;
    }

    @Override
    public List<Stock> getStocks() {
        return null;
    }

    @Override
    public List<Record> getRecords() {
        return null;
    }
}
