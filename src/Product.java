/**
 * Product
 * /Users/austin/IdeaProjects/shopping-cart/src/Product.java
 * Created: 5/2/25
 * Last Modified: 5/2/25
 *
 * Description: This is the class for the products available for purchase. This initializes the variables and
 * creates a method based on the class, so that product can be called as an object in Main.
 */

public class Product {
    private String name;
    private double price;
    public int quantity;

    // Method
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
}
