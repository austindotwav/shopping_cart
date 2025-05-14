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

        // products array with prices; kept simple array for easier addition of products
        Product[] products = {
                new Product("Acrylic Nail Set", 19.99),
                new Product("Gel Nail Set", 24.99),
                new Product("Custom Acrylic Nail Set", 29.99),
                new Product("Custom Gel Nail Set", 34.99),
        };
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // replaced switch statement with while loop for scalability
        boolean shopping = true;
        while (shopping) {
            System.out.println("\nProducts available:");

            // print available products with price; -1 is last item in array
            for (int i = 0; i < products.length - 1; i++) {
                System.out.printf("%d. %s - $%.2f\n", i + 1, products[i].getName(), products[i].getPrice());
            }

            // last choice is always checkout; fully scalable
            System.out.println((products.length +1) + ". View Bag & Checkout");

            System.out.print("Choose a product to add to bag or checkout: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();


            // check if valid choice; if yes add that item to cart
            if (choice >= 1 && choice <= products.length) {
                cart.addProduct(products[choice - 1]);
            } else if (choice == products.length + 1) {
                if (cart.cart.isEmpty()) {
                    System.out.println("You bag is empty!");
                } else {
                    System.out.println("\nWould you like to add custom charms for $9.99/set? (y/n)");
                    String answer = scanner.next();
                    if (answer.equals("y")) {
                        cart.addCharms();
                        shopping = false;
                    } else if (answer.equals("n")) {
                        shopping = false;
                    }
                    // checkout
                    cart.showCart();
                }
                // if invalid keystroke, print errors
            } else {
                System.out.println("Invalid choice");
            }
        } else {
                String invalidInput = scanner.next();
            System.out.println("Invalid input: " + invalidInput);
            }
        }
    }
}