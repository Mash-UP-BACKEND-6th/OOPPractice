import java.util.Objects;

// 상품의 정보만 나타내는 클래스
public class ProductInfo {
    private String name;
    private String brand;
    private int weight;
    private int price;

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

    public ProductInfo(Product product) {
        this(product.getName(),
            product.getBrand(),
            product.getWeight(),
            product.getPrice());
    }

    public ProductInfo(String name, String brand, int weight, int price) {
        this.name = name;
        this.brand = brand;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo productInfo = (ProductInfo) o;
        return weight == productInfo.weight &&
                price == productInfo.price &&
                Objects.equals(name, productInfo.name) &&
                Objects.equals(brand, productInfo.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, weight, price);
    }

    @Override
    public String toString() {
        return "name'" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", price=" + price;
    }
}
