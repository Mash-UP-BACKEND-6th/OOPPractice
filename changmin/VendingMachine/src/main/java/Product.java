import java.util.Date;
import java.util.Objects;

public class Product {
    String name;
    String brand;
    int weight;
    int price;
    Date created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return weight == product.weight &&
                price == product.price &&
                Objects.equals(name, product.name) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(created, product.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, weight, price, created);
    }
}
