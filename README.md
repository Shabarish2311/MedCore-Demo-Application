# MedCore Demo Application

A standalone Java console application demonstrating the features and functionality of the **MedCore Java Library**.

## Overview

MedCore Demo Application demonstrates how developers can integrate and use the MedCore Java Library in a separate Maven-based Java project.

It showcases reusable medicine validation, inventory calculations, billing operations, sales analytics and common validation utilities.

## Technology Stack

- Java 17
- Maven
- MedCore Java Library 1.0.0
- Eclipse IDE

## Project Structure

```text
medcore-demo-application/
│
├── src/main/java/
│   └── com/medcore/demo/
│       ├── analytics/
│       │   └── AnalyticsDemo.java
│       ├── billing/
│       │   └── BillingDemo.java
│       ├── common/
│       │   └── ValidationDemo.java
│       ├── inventory/
│       │   └── InventoryDemo.java
│       ├── main/
│       │   └── MedCoreDemoApplication.java
│       └── medicine/
│           └── MedicineDemo.java
│
└── pom.xml
```

## Features Demonstrated

### 1. Medicine Management
- Interactive medicine detail entry.
- Medicine name and description validation.
- Medicine price validation.
- Stock quantity validation.

### 2. Inventory Management
- Check medicine stock availability.
- Add stock quantities.
- Remove stock quantities.
- Check low-stock conditions.
- Interactive inventory menu.

### 3. Billing Management
- Add multiple medicines dynamically.
- Calculate individual item totals.
- Calculate subtotal.
- Automatically apply a 15% discount when the subtotal exceeds ₹450.
- Calculate the final bill amount.
- Validate billing information.

### 4. Sales Analytics
- Calculate total sales revenue.
- Calculate average sales.
- Calculate total quantity sold.
- Generate monthly sales reports.
- Generate day-wise sales reports.
- Identify top-selling medicines.
- Generate medicine-wise sales distribution.

### 5. Common Validation Utilities
- String validation.
- Positive number validation.
- Non-negative number validation.
- Positive integer validation.
- Non-negative integer validation.

## Requirements

- Java Development Kit (JDK) 17 or later.
- Apache Maven.
- Eclipse IDE or another Java IDE.
- MedCore Java Library 1.0.0 installed in the local Maven repository.

## Maven Dependency

The application uses the MedCore Java Library as an external Maven dependency.

Add the following dependency to `pom.xml`:

```xml
<dependency>
    <groupId>com.medcore</groupId>
    <artifactId>medcore-java-library</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Installation and Execution

1. Clone or download the Demo Application repository.
2. Open the project in Eclipse as an existing Maven project.
3. Ensure that the MedCore Java Library dependency is available in your local Maven repository.
4. Update Maven dependencies.
5. Run `MedCoreDemoApplication.java` as a Java Application.
6. Select the required module from the main menu.

## Example Main Menu

```text
==========================================

       WELCOME TO MEDCORE DEMO

==========================================

          MEDCORE DEMO APPLICATION

1. Medicine Management
2. Inventory Management
3. Billing Management
4. Sales Analytics
5. Common Validation Utilities
6. Exit

Enter your choice:
```

----------------------------------------------------------------------------------------------------------------
## MedCore Java Library

This application uses the MedCore Java Library as an external Maven dependency.

Library Repository: https://github.com/Shabarish2311/MedCore-Java-Library

Maven coordinates:

- Group ID: `com.medcore`
- Artifact ID: `medcore-java-library`
- Version: `1.0.0`

Before running the demo application, clone the library repository and install it into your local Maven repository using:

```bash
mvn clean install
```

Then import and run the demo application.
