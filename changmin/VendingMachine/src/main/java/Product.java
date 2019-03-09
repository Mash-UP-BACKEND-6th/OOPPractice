import java.util.Date;

public class Product extends ProductInfo {
    Date created;

    public Product(String name, String brand, int weight, int price, Date created) {
        super(name, brand, weight, price);
        this.created = created;
    }
}
