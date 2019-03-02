import java.util.*;

public class VendingMachineImpl implements VendingMachine{
    private int insertedMoney = 0;
    //삭제는 없고 삽입은 있다. 랜덤 접근은 테스트말고는 없음
    List<ProductInfo> productInfos = new LinkedList<>();

    //빨리 찾는 것만 중요
    Map<ProductInfo, Integer> stockInfo = new HashMap<>();

    //삽임 삭제가 빈번
    List<Product> stocks = new LinkedList<>();

    @Override
    public void insertMoney(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("No minus money! " + money);
        }
        this.insertedMoney += money;
    }

    @Override
    public void addStock(Product product) {
        ProductInfo productInfo = new ProductInfo(product);
        if (stockInfo.containsKey(productInfo)) {
            stockInfo.put(productInfo, stockInfo.get(productInfo) + 1);
        } else {
            stockInfo.put(productInfo, 1);
            productInfos.add(productInfo);
        }
        stocks.add(product);
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
    public Product buy(ProductInfo productInfo) {
        if (stockInfo.containsKey(productInfo) && stockInfo.get(productInfo) > 0) {
            int count = stockInfo.get(productInfo);
            if(count > 0) {
                stockInfo.put(productInfo, stockInfo.get(productInfo) - 1);
                return stocks.get(0);
            }
        }
        throw new IllegalArgumentException("상품이 존재하지 않거나 재고가 없습니다.");
    }

    @Override
    public int getInsertedMoney() {
        return insertedMoney;
    }

    @Override
    public Map<ProductInfo, Integer> getStocks() {
        return this.stockInfo;
    }

    @Override
    public List<Record> getRecords() {
        return null;
    }
}
