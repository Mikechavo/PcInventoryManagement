import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Part {
    private int id;
    private String name;
    private String brand;
    private int quantity;
    private double price;
    private String imageUrl;
    private String componentType;

    // List of available component types
    public static final String[] COMPONENT_TYPES = {
            "CPU", "GPU", "Motherboard", "RAM", "PSU", "Case", "Cooling System",
            "Monitor", "Keyboard", "Mouse", "Adapter", "Laptop", "Headset", "Controller", "Cable"
    };

    public Part(int id, String name, String brand, int quantity, double price, String imageUrl, String componentType) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.imageUrl = imageUrl;
        this.componentType = componentType;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", componentType='" + componentType + '\'' +
                '}';
    }
}