/**
 * Main
 * /Users/austin/IdeaProjects/shopping-cart/src/Main.java
 * Created: 5/2/25
 * Last Modified: 5/2/25
 *
 * Description: This is a project I created as part of CIT 2613 Advanced Java final.
 * It is a mock shopping cart application that utilizes arrays and switch statements to simulate
 * a user adding items to a cart, and then checking out. The application performs calculations for
 * subtotals, variables (like taxes and add-ons), and totals.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // products array with prices
        Product[] products = {
                new Product("Acrylic Nail Set", 19.99),
                new Product("Gel Nail Set", 24.99),
                new Product("Custom Acrylic Nail Set", 29.99),
                new Product("Custom Gel Nail Set", 34.99),
        };
        ShoppingCart cart = new ShoppingCart();

        // main code
        Scanner scanner = new Scanner(System.in);

        // replaced switch statement with loop for scalability
        boolean shopping = true;
        while (shopping) {
            System.out.println("\nProducts available:");
            for (int i = 0; i < products.length - 1; i++) {
                System.out.printf("%d. %s - $%.2f\n", i + 1, products[i].getName(), products[i].getPrice());
            }
            System.out.println((products.length +1) + ". View Bag & Checkout");

            System.out.print("Choose a product to add to bag or checkout: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= products.length) {
                cart.addProduct(products[choice - 1]);
            } else if (choice == products.length + 1) {
                shopping = false;
                cart.showCart();
            } else {
                System.out.println("Invalid choice");
            }
        }
        // Unimplemented; needs to be updated to work with shopping loop
        // double charms = 9.99 * ;  // $9.99 per set
    }
}