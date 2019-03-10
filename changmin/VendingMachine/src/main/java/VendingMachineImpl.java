import java.util.*;

public class VendingMachineImpl implements VendingMachine{
    private int insertedMoney = 0;
    //삭제는 없고 삽입은 있다. 랜덤 접근은 테스트말고는 없음
    List<ProductInfo> productInfos = new LinkedList<>();

    //빨리 찾는 것만 중요
    Map<ProductInfo, Integer> stockInfo = new HashMap<>();

    //삽입 삭제가 빈번할 수 있다.
    Map<ProductInfo, List<Product>> stocks = new HashMap<>();

    //삽입만 한다.
    List<Product> records = new ArrayList<>();

    @Override
    public void insertMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("넣을 수 없는 액수 입니다." + money);
        }
        this.insertedMoney += money;
    }

    @Override
    public void addStock(Product product) {
        ProductInfo productInfo = new ProductInfo(product);

        if (stockInfo.containsKey(productInfo)) {
            stockInfo.put(productInfo, stockInfo.get(productInfo) + 1);

            List<Product> products = stocks.get(productInfo);
            products.add(product);
        } else {
            stockInfo.put(productInfo, 1);
            productInfos.add(productInfo);

            List<Product> products = new LinkedList<>();
            products.add(product);
            stocks.put(productInfo, products);
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
    public Product buy(ProductInfo productInfo) {
        if (insertedMoney < productInfo.getPrice()) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }

        if (stockInfo.containsKey(productInfo) && stockInfo.get(productInfo) > 0) {
            int count = stockInfo.get(productInfo);
            if(count > 0) {
                insertedMoney -= productInfo.getPrice(); 
                stockInfo.put(productInfo, stockInfo.get(productInfo) - 1);
                Product product = stocks.get(productInfo).get(0);
                records.add(product);
                return product;
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
    public List<Product> getRecords() {
        return records;
    }
}
