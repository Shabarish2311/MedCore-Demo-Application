package com.medcore.demo.main;

import java.util.Scanner;

import com.medcore.demo.medicine.MedicineDemo;
import com.medcore.demo.inventory.InventoryDemo;
import com.medcore.demo.billing.BillingDemo;
import com.medcore.demo.analytics.AnalyticsDemo;
import com.medcore.demo.common.ValidationDemo;

public class MedCoreDemoApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    	int choice = 0;

        System.out.println("==========================================");
        System.out.println("       WELCOME TO MEDCORE DEMO");
        System.out.println("==========================================");

        do {

            displayMenu();

            System.out.print("\nEnter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    MedicineDemo.run();
                    break;

                case 2:
                    InventoryDemo.run();
                    break;

                case 3:
                    BillingDemo.runDemo();
                    break;

                case 4:
                    AnalyticsDemo.runDemo();
                    break;

                case 5:
                    ValidationDemo.runDemo();
                    break;

                case 6:
                    System.out.println("\nThank you for using MedCore Demo Application!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select between 1 and 6.");
            }

            if (choice != 6) {
                System.out.println("\nPress Enter to return to the main menu...");

                scanner.nextLine();
                scanner.nextLine();
            }

        } while (choice != 6);

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n==========================================");
        System.out.println("          MEDCORE DEMO APPLICATION");
        System.out.println("==========================================");

        System.out.println("1. Medicine Management");
        System.out.println("2. Inventory Management");
        System.out.println("3. Billing Management");
        System.out.println("4. Sales Analytics");
        System.out.println("5. Common Validation Utilities");
        System.out.println("6. Exit");

        System.out.println("==========================================");
    }
}

