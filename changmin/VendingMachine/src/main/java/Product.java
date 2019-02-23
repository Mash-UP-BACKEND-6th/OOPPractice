import java.util.Date;
import java.util.Objects;

public class Product {
    private String name;
    private String brand;
    private int weight;
    private int price;
    private Date created;

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public Date getCreated() {
        return created;
    }

    public Product(String name, String brand, int weight, int price, Date created) {
        this.name = name;
        this.brand = brand;
        this.weight = weight;
        this.price = price;
        this.created = created;
    }

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
