
package com.medcore.demo.analytics;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.medcore.analytics.SaleRecord;
import com.medcore.analytics.SalesAnalytics;

public class AnalyticsDemo {

    public static void runDemo() {

        System.out.println("\n==========================================");
        System.out.println("             SALES ANALYTICS");
        System.out.println("==========================================");

        // 1. Create sample sales records
        List<SaleRecord> sales = Arrays.asList(
            new SaleRecord(101, "Paracetamol", 10,new BigDecimal("250.00"),LocalDate.of(2026, 1, 5)),
            new SaleRecord(102, "Dolo", 5,new BigDecimal("100.00"),LocalDate.of(2026, 1, 6)),
            new SaleRecord(101, "Paracetamol", 20,new BigDecimal("500.00"),LocalDate.of(2026, 2, 2)),
            new SaleRecord(103, "Cetirizine", 8,new BigDecimal("160.00"),LocalDate.of(2026, 2, 3)));

        System.out.println("\nTotal Sales Records: " + sales.size());

        // 2. Total sales
        System.out.println("\n1. TOTAL SALES");

        BigDecimal totalSales =SalesAnalytics.calculateTotalSales(sales);

        System.out.println("Total Sales Revenue: " + formatAmount(totalSales));

        // 3. Average sales
        System.out.println("\n2. AVERAGE SALES");

        BigDecimal averageSales = SalesAnalytics.calculateAverageSales(sales);

        System.out.println("Average Sales Value: " + formatAmount(averageSales));

        // 4. Total quantity sold
        System.out.println("\n3. TOTAL QUANTITY SOLD");

        int totalQuantity = SalesAnalytics.calculateTotalQuantitySold(sales);

        System.out.println("Total Units Sold: " + totalQuantity);

        // 5. Monthly sales
        System.out.println("\n4. MONTHLY SALES REPORT");

        Map<YearMonth, BigDecimal> monthlySales = SalesAnalytics.getMonthlySales(sales);

        System.out.printf("%-20s %s%n", "Month", "Sales Revenue");
        System.out.println("------------------------------------------");

        for (Map.Entry<YearMonth, BigDecimal> entry : monthlySales.entrySet()) {
            String monthName = entry.getKey().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            int year = entry.getKey().getYear();
            System.out.printf("%-20s %s%n",monthName + " " + year,formatAmount(entry.getValue()));
        }

        // 6. Sales by day
        System.out.println("\n5. DAY-WISE SALES REPORT");

        Map<DayOfWeek, BigDecimal> salesByDay = SalesAnalytics.getSalesByDay(sales);

        System.out.printf("%-20s %s%n", "Day", "Sales Revenue");
        System.out.println("------------------------------------------");

        for (Map.Entry<DayOfWeek, BigDecimal> entry : salesByDay.entrySet()) {
            String dayName = entry.getKey().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            System.out.printf("%-20s %s%n",dayName,formatAmount(entry.getValue()));
        }

        // 7. Top-selling medicines
        System.out.println("\n6. TOP-SELLING MEDICINES");

        Map<String, Integer> topMedicines = SalesAnalytics.getTopSellingMedicines(sales, 3);

        System.out.printf("%-25s %s%n", "Medicine", "Units Sold");
        System.out.println("------------------------------------------");

        for (Map.Entry<String, Integer> entry : topMedicines.entrySet()) {
        	System.out.printf("%-25s %d%n",entry.getKey(), entry.getValue());
        }

        // 8. Medicine sales distribution
        System.out.println("\n7. MEDICINE-WISE SALES DISTRIBUTION");

        Map<String, BigDecimal> distribution = SalesAnalytics.getMedicineSalesDistribution(sales);

        System.out.printf("%-25s %s%n", "Medicine", "Sales Revenue");
        System.out.println("------------------------------------------");

        for (Map.Entry<String, BigDecimal> entry : distribution.entrySet()) {
            System.out.printf("%-25s %s%n",entry.getKey(),formatAmount(entry.getValue()));
        }

        System.out.println("\n==========================================");
        System.out.println("     SALES ANALYTICS COMPLETED");
        System.out.println("==========================================");
    }

    // Format monetary values
    private static String formatAmount(BigDecimal amount) {
        return amount.setScale(2, java.math.RoundingMode.HALF_UP).toString();
    }
}
