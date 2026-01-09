import java.util.List;
   
    import java.util.ArrayList;
import java.util.Scanner;

public class InventorySystem {
    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        system.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. View All Products");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: updateQuantity(); break;
                case 3: removeProduct(); break;
                case 4: viewProducts(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private void addProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();

        products.add(new Product(id, name, qty));
        System.out.println("Product added successfully.");
    }

    private void updateQuantity() {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                System.out.print("Enter new quantity: ");
                int newQty = scanner.nextInt();
                p.setQuantity(newQty);
                System.out.println("Quantity updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private void removeProduct() {
        System.out.print("Enter product ID to remove: ");
        int id = scanner.nextInt();
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                System.out.println("Product removed.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("--- Product List ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}


