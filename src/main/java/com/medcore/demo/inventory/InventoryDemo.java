
package com.medcore.demo.inventory;

import java.util.Scanner;

import com.medcore.inventory.InventoryCalculator;
import com.medcore.inventory.StockValidator;

public class InventoryDemo {

    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {

        System.out.println("\n========== INVENTORY MANAGEMENT DEMO ==========");

        System.out.print("Enter medicine name: ");
        String medicineName = scanner.nextLine();

        System.out.print("Enter current stock quantity: ");
        int currentStock = readInteger();

        if (!StockValidator.isValidStock(currentStock)) {
            System.out.println("Invalid current stock quantity!");
            return;
        }

        System.out.print("Enter low-stock threshold: ");
        int lowStockThreshold = readInteger();

        if (!StockValidator.isValidStock(lowStockThreshold)) {
            System.out.println("Invalid low-stock threshold!");
            return;
        }

        int choice;

        do {
            System.out.println("\nMedicine: " + medicineName);
            System.out.println("Current Stock: " + currentStock);

            System.out.println("\n========== INVENTORY MENU ==========");
            System.out.println("1. Check Available Stock");
            System.out.println("2. Add Stock");
            System.out.println("3. Remove Stock");
            System.out.println("4. Check Low Stock");
            System.out.println("5. Exit");
            System.out.println("====================================");

            System.out.print("\nEnter your choice: ");
            choice = readInteger();

            switch (choice) {

                case 1:
                    System.out.print("Enter required quantity: ");
                    int requiredQuantity = readInteger();

                    if (requiredQuantity <= 0) {
                        System.out.println("Required quantity must be greater than zero!");
                        break;
                    }

                    boolean available = InventoryCalculator.isAvailable(currentStock, requiredQuantity);

                    if (available) {
                        System.out.println("Stock is available!");
                        System.out.println("Available Quantity: " + currentStock);
                    } else {
                        System.out.println("Insufficient stock!");
                        System.out.println("Available Quantity: " + currentStock);
                        System.out.println("Required Quantity: " + requiredQuantity);
                    }
                    break;

                case 2:
                    System.out.print("Enter quantity to add: ");
                    int addQuantity = readInteger();

                    if (StockValidator.isValidStockAddition(addQuantity)) {
                        currentStock = InventoryCalculator.addStock(currentStock, addQuantity);

                        System.out.println("Stock added successfully!");
                        System.out.println("Updated Stock: " + currentStock);
                    } else {
                        System.out.println("Invalid stock addition!");
                    }
                    break;

                case 3:
                    System.out.print("Enter quantity to remove: ");
                    int removeQuantity = readInteger();

                    if (StockValidator.isValidStockRemoval(currentStock, removeQuantity)) {

                        currentStock = InventoryCalculator.removeStock(currentStock, removeQuantity);

                        System.out.println("Stock removed successfully!");
                        System.out.println("Updated Stock: " + currentStock);
                    } else {
                        System.out.println("Invalid stock removal!");
                    }
                    break;

                case 4:
                    System.out.println("Low Stock: " +InventoryCalculator.isLowStock(currentStock, lowStockThreshold));
                    break;

                case 5:
                    System.out.println("Exiting Inventory Management...");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1 to 5.");
            }

        } while (choice != 5);

        System.out.println("======================================");
    }

    private static int readInteger() {

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter a valid integer: ");
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }
}
