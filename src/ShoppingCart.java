import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cart = new ArrayList<>();


    public void addProduct(Product product) {
        if (!cart.contains(product)) {  // prevents duplicate product entries for quantity handling
            cart.add(product);
        }
        product.incrementQuantity();
        System.out.println(product.getName() + " added to bag!");
    }

    public List<Product> getCart() {
        return cart;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Product product : cart) {
            subtotal += product.getPrice() * product.getQuantity();
        }
        return subtotal;
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("No items in bag!");
            return;
        }

        // all cart functions are handled by the shopping cart class now
        System.out.println("\nBag Summary:");
        for (Product product : cart) {
            double totalPrice = product.getPrice() * product.getQuantity();
            System.out.printf("(%d) %s - $%.2f\n", product.getQuantity(), product.getName(), totalPrice);
        }

        double subtotal = getSubtotal();
        double taxRate = 0.0825;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        System.out.printf("\nSubtotal: $%.2f", subtotal);
        System.out.printf("\nTax (8.25%%): $%.2f\n", tax);
        System.out.printf("Total: $%.2f\n", total);
    }
}