package com.medcore.demo.common;

import java.math.BigDecimal;
import java.util.Scanner;

import com.medcore.common.ValidationUtils;

public class ValidationDemo {

    private static final Scanner scanner = new Scanner(System.in);

    public static void runDemo() {

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("        COMMON VALIDATION UTILITIES");
            System.out.println("==========================================");

            System.out.println("1. String Validation");
            System.out.println("2. Positive Number Validation");
            System.out.println("3. Non-Negative Number Validation");
            System.out.println("4. Positive Integer Validation");
            System.out.println("5. Non-Negative Integer Validation");
            System.out.println("6. Exit");

            System.out.println("==========================================");

            System.out.print("Enter your choice: ");
            choice = readInteger();

            switch (choice) {

                case 1:
                    validateString();
                    break;

                case 2:
                    validatePositiveNumber();
                    break;

                case 3:
                    validateNonNegativeNumber();
                    break;

                case 4:
                    validatePositiveInteger();
                    break;

                case 5:
                    validateNonNegativeInteger();
                    break;

                case 6:
                    System.out.println("\nExiting Common Validation Utilities...");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select 1 to 6.");
            }

            if (choice != 6) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }

        } while (choice != 6);

        System.out.println("==========================================");
    }

    // 1. String validation
    private static void validateString() {

        System.out.println("\n========== STRING VALIDATION ==========");

        System.out.print("Enter a string: ");
        String value = scanner.nextLine();

        boolean result = ValidationUtils.isNotEmpty(value);

        System.out.println("Input: " + value);
        System.out.println("Is Not Empty: " + result);
    }

    // 2. Positive number validation
    private static void validatePositiveNumber() {

        System.out.println("\n====== POSITIVE NUMBER VALIDATION ======");

        BigDecimal value = readBigDecimal();

        System.out.println("Input: " + value);
        System.out.println("Is Positive Number: " +ValidationUtils.isPositiveNumber(value));
    }

    // 3. Non-negative number validation
    private static void validateNonNegativeNumber() {

        System.out.println("\n=== NON-NEGATIVE NUMBER VALIDATION ===");

        BigDecimal value = readBigDecimal();

        System.out.println("Input: " + value);
        System.out.println("Is Non-Negative Number: " +ValidationUtils.isNonNegativeNumber(value));
    }

    // 4. Positive integer validation
    private static void validatePositiveInteger() {

        System.out.println("\n====== POSITIVE INTEGER VALIDATION ======");

        int value = readIntegerValue();

        System.out.println("Input: " + value);
        System.out.println("Is Positive Integer: " +ValidationUtils.isPositiveInteger(value));
    }

    // 5. Non-negative integer validation
    private static void validateNonNegativeInteger() {

        System.out.println("\n=== NON-NEGATIVE INTEGER VALIDATION ===");

        int value = readIntegerValue();

        System.out.println("Input: " + value);
        System.out.println("Is Non-Negative Integer: " +ValidationUtils.isNonNegativeInteger(value));
    }

    // Read decimal number
    private static BigDecimal readBigDecimal() {

        while (true) {

            System.out.print("Enter a number: ");
            String input = scanner.nextLine().trim();

            try {
                return new BigDecimal(input);

            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter a valid decimal value.");
            }
        }
    }

    // Read integer value
    private static int readIntegerValue() {

        while (true) {

            System.out.print("Enter an integer: ");
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Invalid integer! Please enter a valid integer.");
            }
        }
    }

    // Read menu choice
    private static int readInteger() {

        while (true) {

            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a valid menu choice: ");
            }
        }
    }
}
