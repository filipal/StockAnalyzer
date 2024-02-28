package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static List<Double> stockPrices = new ArrayList<>();

 // This section of the code continuously displays the main menu to the user within an infinite loop.
 // The menu is enhanced with color coding for improved readability: a welcoming message in red
 // and the options in green. Each option represents a different functionality of the Stock Price Analyzer program,
 // allowing users to enter stock prices, calculate the average price, find the maximum price, count occurrences
 // of a specific price, calculate the cumulative sum, or exit the program. After displaying the options,
 // the program prompts the user to make a choice by entering the number corresponding to the desired action.
 // The choice is then captured using scanner.nextInt(), determining the next course of action based on the user's selection.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(ANSI_RED + "Welcome to the Stock Price Analyzer!" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "1. Enter stock prices" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "2. Calculate the average stock price" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "3. Find the maximum stock price" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "4. Count occurrences of a specific price" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "5. Calculate the cumulative sum of stock prices" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "6. Exit the program" + ANSI_RESET);

            System.out.print(ANSI_RED + "Choose an option: " + ANSI_RESET);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input stream after reading a number

         // This switch statement processes the user's choice from the main menu.
            switch (choice) {
                case 1:
                	// Option 1 allows the user to enter stock prices. It calls a method to handle the input process.
                    enterStockPrices(scanner);
                    break;
                case 2:
                    // Option 2 calculates the average stock price. Before proceeding, it checks if any stock prices have been entered.
                    // If not, it prompts the user to enter stock prices first.
                    if(stockPrices.isEmpty()) {
                        System.out.println("Please enter the stock prices first.");
                    } else {
                    	calculateAveragePrice();
                        break;
                    }
                    break;
                case 3:
                    // Option 3 is responsible for finding the maximum stock price. Before it proceeds,
                    // it checks if the stockPrices list contains any entries. This is to ensure
                    // that there are data points to work with for finding the maximum price.
                    if(stockPrices.isEmpty()) {
                        System.out.println("Please enter the stock prices first.");
                    } else {
                    	// If there are entries in the stockPrices list, the user is prompted to choose
                        // the method for finding the maximum stock price. Two options are provided:
                        // (1) Using the Array method
                        // (2) Using the ArrayList method
                        // This allows the user to select the preferred data structure for the operation.
                        System.out.println("Choose the method for finding the maximum price:\n(1) Using the Array method\n(2) Using the ArrayList method");
                        int methodChoice = scanner.nextInt(); // Captures the user's choice
                        // Based on the user's selection, a switch-case structure is used to execute
                        // the corresponding method. This approach enables flexibility and makes it
                        // easy to extend the program with more methods in the future.
                        switch(methodChoice) {
                        	// If the user chooses option 1, the existing method for finding the maximum
                        	// price using an array is called. This might involve converting the ArrayList
                        	// to an array or using a method that operates directly on an array.
                            case 1:
                                findMaximumPrice();  // Calls the new method using Array
                                break;
                            case 2:
                            	// If the user chooses option 2, the method for finding the maximum price
                                // using the ArrayList is called. This method directly operates on the
                                // ArrayList without needing conversion, potentially offering a more
                                // straightforward approach for manipulation.
                            	findMaximumPriceUsingArrayList(); // Calls the new method using ArrayList
                                break;
                            default:
                            	// If the user enters a choice that is not recognized (not 1 or 2),
                                // an error message is displayed, and they are prompted to try again.
                                // This ensures that the user input is validated and only valid selections
                                // are processed.
                                System.out.println("Invalid selection, please try again.");
                        }
                    }
                    break; // Breaks out of the switch-case structure after handling option 3.
                case 4:
                	// Option 4 counts the occurrences of a specific stock price. It requires stock prices to be entered beforehand.
                    if(stockPrices.isEmpty()) {
                        System.out.println("Please enter the stock prices first.");
                    } else {
                    	countOccurrences(scanner);
                        break;
                    }
                    break;
                case 5:
                	// Option 5 calculates the cumulative sum of stock prices, with a prerequisite that stock prices are entered.
                    if(stockPrices.isEmpty()) {
                        System.out.println("Please enter the stock prices first.");
                    } else {
                    	computeCumulativeSum();
                        break;
                    }
                    break;
                case 6:
                	// Option 6 exits the program. It prints a message confirming the exit and terminates the application.
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                	// This default case handles any input that does not match options 1-6, prompting the user to try again.
                    System.out.println("Invalid option, please try again.");
            }
            // Each 'case' block corresponds to a specific functionality within the Stock Price Analyzer program,
            // guiding the user through various analyses and operations on entered stock prices.
        } 
    }
    
 // This method calculates the average stock price from the list of entered stock prices.
    private static void calculateAveragePrice() {
    	// First, it checks if the list of stock prices is empty. If it is, it prompts the user to enter stock prices before attempting any calculations.
        if (stockPrices.isEmpty()) {
            System.out.println("Please first enter the stock prices.");
            return; // Exits the method to prevent further execution.
        }
        
        double sum = 0; // Initializes a variable to hold the sum of all stock prices.
        // Loops through each stock price in the list, adding each price to the sum.
        for (Double price : stockPrices) {
            sum += price;
        }
        // Calculates the average price by dividing the sum by the total number of prices in the list.
        double average = sum / stockPrices.size();
        // Prints the calculated average price to the console, formatted to two decimal places.	
        System.out.printf("The average of the entered stock prices is: %.2f\n", average);
    }
    // The purpose of this method is to provide the user with the average value of all entered stock prices,
 	// offering insight into the general performance of the stock over the entered period.


    
    private static void findMaximumPriceUsingArrayList() {
    	// First, check if the stockPrices list is empty. This is important because
        // trying to find a maximum price in an empty list would not only be impossible,
        // but could also lead to errors. This check ensures that the method proceeds
        // only when there are prices to work with.
        if (stockPrices.isEmpty()) {
            System.out.println("No stock prices have been entered.");
            return; // Exits the method early if the list is empty, preventing further execution.
        }
        // If the list is not empty, the Collections.max method is used to find the maximum price.
        // This method is a part of the Java Collections Framework and provides a convenient way
        // to find the maximum element in a collection of elements. In this case, it is used
        // to find the maximum price in the list of stock prices.
        double maxPrice = Collections.max(stockPrices);
        // Finally, the maximum price found using the ArrayList is printed to the console.
        // The message includes the maximum price, formatted to indicate that it was found
        // using the ArrayList data structure. This provides clear feedback to the user
        // about the result of the operation.
        System.out.println("The maximum price using ArrayList: " + maxPrice);
    }
  

    private static void findMaximumPrice() {
    	// This method calculates the maximum stock price from the entered stock prices.
    	// First, check if any stock prices have been entered. If not, prompt the user to enter prices first.
        if (stockPrices.isEmpty()) {
        	// If no stock prices have been entered, it prompts the user to enter them before proceeding.
            System.out.println("Please first enter the stock prices.");
            return; // Exits the method to prevent further execution without stock prices.
        }

        double maxPrice = Double.MIN_VALUE; // Initializes the variable to store the maximum price, starting with the smallest possible double value.
        // Iterates through each price in the stockPrices list.
        for (Double price : stockPrices) {
        	// If the current price is greater than the current maximum price, updates maxPrice to this higher value.
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
     // Once all prices have been checked, prints out the highest stock price found.
        System.out.printf("The maximum stock price is: %.2f\n", maxPrice);
    }
    
    
    // This method counts the occurrences of a specific price among the entered stock prices.
    private static void countOccurrences(Scanner scanner) {
    	// Check if the stock prices list is empty. If so, prompt the user to enter prices first.
        if (stockPrices.isEmpty()) {
            System.out.println("Please enter the stock prices first.");
            return; // Exit the method if no prices are entered.
        }
        // Prompt the user to enter the price they want to count the occurrences of.
        System.out.print("Enter the price to count occurrences: ");
        double targetPrice;
        try {
        	// Parse the user input into a double. If parsing fails, catch the NumberFormatException.
            targetPrice = Double.parseDouble(scanner.nextLine());         
        } catch (NumberFormatException e) {
        	// If the input is not a valid double, inform the user and exit the method.
            System.out.println("Invalid input. Please enter a numerical value.");
            return;
        }
        // Initialize a counter to keep track of how many times the target price occurs.
        int count = 0;
        // Iterate through each price in the stockPrices list.
        for (Double price : stockPrices) {
        	// If the current price equals the target price, increment the counter.
            if (price.equals(targetPrice)) {
                count++;
            }
        }
        // Print the total count of occurrences of the target price.
        System.out.println("The price " + targetPrice + " appears " + count + " times.");
    }

    // Check if the stock prices list is empty. If so, prompt the user to enter price
    private static void computeCumulativeSum() {
    	// Check if the stock prices list is empty. If so, prompt the user to enter prices first.
        if (stockPrices.isEmpty()) {
            System.out.println("Please enter the stock prices first.");
            return; // Exit the method if no prices are entered.
        }
        // Initialize a new list to store the cumulative sums.
        List<Double> cumulativeSums = new ArrayList<>();
        // Initialize a variable to keep track of the running total.
        double sum = 0;
        // Iterate through each price in the stockPrices list.
        for (Double price : stockPrices) {
        	// Add the current price to the running total.
            sum += price;
            // Add the new total to the list of cumulative sums.
            cumulativeSums.add(sum);
        }
        // Print the title for the list of cumulative sums.
        System.out.println("Cumulative sum of stock prices:");
        // Iterate through the cumulativeSums list and print each value.
        for (Double cumulativeSum : cumulativeSums) {
        	// Format the output to two decimal places.
            System.out.printf("%.2f\n", cumulativeSum);
        }
    }

    // This method allows the user to enter multiple stock prices separated by semicolons and store them in a list.
    private static void enterStockPrices(Scanner scanner) {
    	// Prompt the user to enter stock prices, allowing multiple entries separated by ";"
        System.out.println("Enter stock prices separated by ';' (type 'end' to finish):");
        while (true) {
            System.out.print("Enter prices or 'end' to return: ");
            // Read the user input
            String inputLine = scanner.nextLine();

            // Check if the user wants to return to the main menu
            if ("end".equalsIgnoreCase(inputLine.trim())) {
                System.out.println("Returning to the main menu.");
                break; // Break the loop to exit the method
            }
            // If the input is empty, prompt the user to try again
            if (inputLine.isEmpty()) {
                System.out.println("No data entered. Please try again.");
                continue; // Continue to the next iteration of the loop
            }
            // Split the input string into individual prices based on ";"
            String[] prices = inputLine.split(";");
            boolean allValid = true; // Flag to check if all entered prices are valid
            List<Double> validPrices = new ArrayList<>(); // List to store valid prices

            // Iterate through each split string to parse and validate individual prices
            for (String priceStr : prices) {
                try {
                	// Parse the string to a double, trimming any leading or trailing whitespace
                    double price = Double.parseDouble(priceStr.trim());
                    // Check if the price is negative, which is not allowed
                    if (price < 0) {
                        System.out.println("Price cannot be negative: " + price);
                        allValid = false; // Invalidate the current set of prices
                        break; // Exit the loop since validation failed
                    } else {
                    	// If the price is valid, add it to the list of valid prices
                        validPrices.add(price);
                    }
                } catch (NumberFormatException e) {
                	// Catch and handle the exception if the string cannot be parsed to a double
                    System.out.println("Invalid input: '" + priceStr + "'. Please enter numbers separated by ';'.");
                    allValid = false; // Invalidate the current set of prices
                    break; // Exit the loop since validation failed
                }
            }
            // If all prices are valid, add them to the main list of stock prices
            if (allValid) {
                stockPrices.addAll(validPrices); // Add all valid prices to the global list
                System.out.println("Prices entered successfully.");
                // Provide the user with an option to enter more prices or return to the main menu
                System.out.println("Would you like to enter more prices? (y/n)");
                String answer = scanner.nextLine();
                // If the user chooses not to enter more prices, return to the main menu
                if ("n".equalsIgnoreCase(answer.trim())) {
                    System.out.println("\"Returning to the main menu.");
                    break; // Break the loop to exit the method
                }
            }
        }
    }
}