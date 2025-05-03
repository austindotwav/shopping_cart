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

        // Products array with prices
        Product[] products = {
                new Product("Acrylic Nail Set", 19.99),
        new Product("Gel Nail Set", 24.99),
        new Product("Custom Acrylic Nail Set", 29.99),
        new Product("Custom Gel Nail Set", 34.99),
        };

        int totalItems = 0;

        // Main code
        Scanner scanner = new Scanner(System.in);

        boolean shopping = true;
        while (shopping) {
            System.out.println("\nProducts available:");
            for (int i = 0; i < products.length -1; i++) {
                System.out.printf("%d. %s - $%.2f\n", i + 1, products[i].name, products[i].price);
            }

            System.out.println("4. View Cart & Checkout");
            System.out.println("Choose a product to add to cart (1-3) or 4 to checkout:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    products[choice - 1].quantity++;
                    totalItems += products[choice - 1].quantity;
                    System.out.println(products[choice - 1].name + " added to cart!");
                    break;

                case 4:
                    System.out.println("Would you like to add custom charms for $9.99? (y/n)");
                    if (scanner.next().toLowerCase().equals("y")) {
                        products[choice - 1].quantity++;
                        System.out.println(products[choice - 1].name + " added to cart!");
                    }
                    shopping = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please choose 1-3 to add an item or 4 to view cart.");
            }
        }

        double subtotal = 0;
        double taxRate = 0.0825;    // 8.25% simulated tax rate
        double charms = 9.99 * totalItems;  // $9.99 per set

        System.out.println("\nCart Summary:");
        for (Product product : products) {
            if (product.quantity > 0) {
                double totalPrice = product.price * product.quantity;

                System.out.println("\n(" + product.quantity + ") " + product.name + " $" + totalPrice);
                subtotal += totalPrice;

                // Charms need to be fully implemented into total
                System.out.println("\n(" + totalItems + ") " + " Charms " + "$" + charms);
            }
        }

        double tax = subtotal * taxRate;
        double total = subtotal + tax + charms;


        System.out.printf("\nSubtotal: $%.2f", subtotal);
        System.out.printf("\nTax (8.25%%): $%.2f\n", tax);
        System.out.printf("Total: $%.2f\n", total);

        }
    }