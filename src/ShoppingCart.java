import java.util.ArrayList;
import java.util.List;

// create cart arraylist; set hasCharms = false/charmCost = 0 to avoid addition to cart
public class ShoppingCart {
    public List<Product> cart = new ArrayList<>();
    private boolean hasCharms = false;
    private double charmCost = 0;

    // adds product to bag; check for duplicate entries
    public void addProduct(Product product) {
        if (!cart.contains(product)) {
            cart.add(product);
        }
        product.incrementQuantity();
        System.out.println(product.getName() + " added to bag!");
    }

    // add extras to bag at checkout; set hasCharms = true for later use
    public void addCharms() {
        hasCharms = true;
        for (Product p : cart) {
            charmCost += p.getQuantity() * 9.99;
        }
    }
    // addCharms return statements
    public boolean hasCharms() {
        return hasCharms;
    }
    public double getCharmCost() {
        return charmCost;
    }

    // calculate subtotal based on product price and quantity
    public double getSubtotal() {
        double subtotal = 0;
        for (Product product : cart) {
            subtotal += product.getPrice() * product.getQuantity();
        }

        // if charms added, calculate charmCost in subtotal
        if (hasCharms) {
            subtotal += charmCost;
        }
        return subtotal;
    }

    // checkout process; if bag empty, print error;
    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("No items in bag!");
            return;
        }

        // print bag summary
        System.out.println("\nBag Summary:");
        for (Product product : cart) {
            double totalPrice = product.getPrice() * product.getQuantity();
            System.out.printf("(%d) %s - $%.2f\n", product.getQuantity(), product.getName(), totalPrice);

        }
        if (hasCharms) {
            System.out.printf("Charms - $%.2f\n", charmCost);
        }

        // calculate tax and print totals
        double subtotal = getSubtotal();
        double taxRate = 0.0825;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        System.out.printf("\nSubtotal: $%.2f", subtotal);
        System.out.printf("\nTax (8.25%%): $%.2f\n", tax);
        System.out.printf("Total: $%.2f\n", total);
    }
}