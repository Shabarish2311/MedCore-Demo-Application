
package com.medcore.demo.billing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.medcore.billing.BillingCalculator;
import com.medcore.billing.BillValidator;

public class BillingDemo {

    private static final Scanner scanner = new Scanner(System.in);

    public static void runDemo() {

        System.out.println("\n==========================================");
        System.out.println("          BILLING MANAGEMENT");
        System.out.println("==========================================");

        List<BigDecimal> itemTotals = new ArrayList<>();
        List<String> medicineNames = new ArrayList<>();
        List<BigDecimal> medicinePrices = new ArrayList<>();
        List<Integer> medicineQuantities = new ArrayList<>();

        int choice;

        // 1. Accept medicine details
        do {

            System.out.println("\nEnter Medicine Details");

            System.out.print("Medicine Name: ");
            String medicineName = scanner.nextLine().trim();

            while (medicineName.isEmpty()) {
                System.out.print("Medicine name cannot be empty. Enter again: ");
                medicineName = scanner.nextLine().trim();
            }

            BigDecimal unitPrice = readPositivePrice();

            int quantity = readPositiveInteger();

            BigDecimal itemTotal = BillingCalculator.calculateItemTotal(unitPrice, quantity);

            medicineNames.add(medicineName);
            medicinePrices.add(unitPrice);
            medicineQuantities.add(quantity);
            itemTotals.add(itemTotal);

            System.out.println("\nMedicine added successfully!");
            System.out.println("Item Total: " + itemTotal);

            System.out.print("\nAdd another medicine? (1 = Yes, 0 = No): ");
            choice = readChoice();

            while (choice != 0 && choice != 1) {
                System.out.print("Invalid choice! Enter 1 or 0: ");
                choice = readChoice();
            }

        } while (choice == 1);

        // 2. Calculate subtotal
        BigDecimal[] items = itemTotals.toArray(new BigDecimal[0]);

        BigDecimal subtotal = BillingCalculator.calculateSubtotal(items);

        // 3. Automatic discount calculation
        BigDecimal discountPercentage;

        if (subtotal.compareTo(new BigDecimal("450")) > 0) {
            discountPercentage = new BigDecimal("15");
        } else {
            discountPercentage = BigDecimal.ZERO;
        }

        BigDecimal discount = BillingCalculator.calculateDiscount(subtotal, discountPercentage);

        // 4. Calculate final amount
        BigDecimal finalAmount = BillingCalculator.calculateFinalAmount(subtotal, discount);

        // 5. Display bill
        System.out.println("\n==========================================");
        System.out.println("                FINAL BILL");
        System.out.println("==========================================");

        System.out.printf("%-18s %10s %8s %12s%n","Medicine", "Price", "Qty", "Total");

        System.out.println("------------------------------------------");

        for (int i = 0; i < medicineNames.size(); i++) {

            System.out.printf("%-18s %10s %8d %12s%n",medicineNames.get(i),medicinePrices.get(i),medicineQuantities.get(i),
            		itemTotals.get(i));
        }

        System.out.println("------------------------------------------");

        System.out.println("Subtotal          : " + subtotal);
        System.out.println("Discount Rate     : " + discountPercentage + "%");
        System.out.println("Discount Amount   : " + discount);
        System.out.println("------------------------------------------");
        System.out.println("Final Bill Amount : " + finalAmount);

        System.out.println("==========================================");

        // 6. Bill validation
        System.out.println("\n========== BILL VALIDATION ==========");

        System.out.println("Valid Bill Amount: " +BillValidator.isValidBillAmount(finalAmount));

        System.out.println("Valid Bill Items: " +BillValidator.hasBillItems(medicineNames));

        boolean allItemsValid = true;

        for (int i = 0; i < medicineNames.size(); i++) {

            boolean valid = BillValidator.isValidBillItem(i + 1,medicineQuantities.get(i),medicinePrices.get(i));

            if (!valid) {
                allItemsValid = false;
                break;
            }
        }

        System.out.println("All Bill Items Valid: " + allItemsValid);

        System.out.println("\nBilling demonstration completed.");
    }

    // Read positive medicine price
    private static BigDecimal readPositivePrice() {

        while (true) {

            System.out.print("Unit Price: ");

            try {
                BigDecimal price = new BigDecimal(scanner.nextLine().trim());

                if (price.compareTo(BigDecimal.ZERO) > 0) {
                    return price;
                }

                System.out.println("Price must be greater than zero.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid price! Enter a valid numeric value.");
            }
        }
    }

    // Read positive quantity
    private static int readPositiveInteger() {

        while (true) {

            System.out.print("Quantity: ");

            try {
                int quantity = Integer.parseInt(scanner.nextLine().trim());

                if (quantity > 0) {
                    return quantity;
                }

                System.out.println("Quantity must be greater than zero.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity! Enter a valid integer.");
            }
        }
    }

    // Read 1 or 0
    private static int readChoice() {

        while (true) {

            try {
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter 1 or 0: ");
            }
        }
    }
}
