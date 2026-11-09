
package com.medcore.demo.medicine;

import java.math.BigDecimal;
import java.util.Scanner;

import com.medcore.medicine.MedicineValidator;

public class MedicineDemo {

    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {

        System.out.println("\n========== MEDICINE VALIDATION DEMO ==========");

        System.out.print("Enter medicine name: ");
        String name = scanner.nextLine();

        System.out.print("Enter medicine description: ");
        String description = scanner.nextLine();

        System.out.print("Enter medicine price: ");
        BigDecimal price = readBigDecimal();

        System.out.print("Enter available stock: ");
        int stock = readInteger();

        System.out.println("\n========== VALIDATION RESULTS ==========");

        boolean validMedicine = MedicineValidator.isValidMedicine(name, description, price, stock);

        System.out.println("Valid Medicine       : " + validMedicine);
        System.out.println("Valid Name           : " +MedicineValidator.isValidName(name));
        System.out.println("Valid Description    : " +MedicineValidator.isValidDescription(description));
        System.out.println("Valid Price          : " +MedicineValidator.isValidPrice(price));
        System.out.println("Valid Stock          : " +MedicineValidator.isValidStock(stock));

        System.out.println("========================================");
    }

    private static BigDecimal readBigDecimal() {
        while (!scanner.hasNextBigDecimal()) {
            System.out.print("Invalid input! Enter a valid price: ");
            scanner.next();
        }

        BigDecimal value = scanner.nextBigDecimal();
        scanner.nextLine();
        return value;
    }

    private static int readInteger() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Enter a valid stock quantity: ");
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
