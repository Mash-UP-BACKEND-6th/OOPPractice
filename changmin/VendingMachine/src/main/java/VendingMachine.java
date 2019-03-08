import java.util.List;
import java.util.Map;

public interface VendingMachine {
    //자판기 금액을 원하는 금액만큼 올리는 함수
    void insertMoney(int money);

    //특정 상품 인스턴스를 넘겨서 재고를 추가하는 함수
    void addStock(Product product);

    //현재 금액으로 구매가능한 상품 목록을 리턴하는 함수
    List<ProductInfo> getProductList();

    //특정 상품를 구매하는 함수
    Product buy(ProductInfo productInfo);

    //잔액을 확인하는 함수
    int getInsertedMoney();

    //전체 상품 재고를 (사전으로 표현하는) 종류별로 리턴하는 함수
    Map<ProductInfo, Integer> getStocks();

    //시작이후 구매 상품 이력을 배열로 리턴하는 함수
    List<Product>  getRecords();
}
