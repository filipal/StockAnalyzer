# StockAnalyzer
Stock Price Analyzer (average, maximum, cumulative sum stock price, occurrence count of a specific price)

# Stock Analyzer Documentation
# Introduction
The “Stock Analyzer” is a Java-based application designed to perform various operations on stock prices entered by the user. It offers functionalities such as entering stock prices, calculating the average, finding the maximum price, counting occurrences of a specific price, and computing the cumulative sum.

# System Requirements
- Java Development Kit (JDK) 8 or higher.
- An IDE that supports Java (e.g., IntelliJ IDEA, Eclipse, or NetBeans).

# Code Structure
Main Class
The ‘Main’ class serves as the entry point of the application and hosts the main menu and all functionalities.
Main Method
The ‘main’ method implements an infinite loop displaying the main menu with options for the user to select different functionalities.
- Displaying the Main Menu: Uses ANSI colors for enhanced readability, offering options to the user and capturing their choice with a ‘Scanner’.

# Option Handlers
Each option in the main menu corresponds to a specific functionality:
1. Enter Stock Prices: Prompts the user to input stock prices, which are stored in an ‘ArrayList<Double>‘.
2. Calculate the Average Stock Price: Computes the average of entered stock prices.
3. Find the Maximum Stock Price: Allows the user to choose between finding the maximum price using an array or an ‘ArrayList’
4. Count Occurrences of a Specific Price: Counts how many times a specified price appears in the list.
5. Calculate the Cumulative Sum of Stock Prices: Computes the cumulative sum of entered prices.
6. Exit the Program: Terminates the application.

# Utility Methods
‘calculateAveragePrice()’: Calculates and displays the average of entered stock prices.
‘findMaximumPriceUsingArrayList()’: Finds and displays the maximum stock price using the ‘ArrayList’ data structure.
‘findMaximumPrice()’: Finds and displays the maximum stock price, intended to work with an array.
‘findMaximumPriceUsingArrayList ()’: Finds and displays the maximum stock price, intended to work with an Array.
‘countOccurrences(Scanner scanner)’: Counts and displays the occurrences of a specific price entered by the ArrayList.
‘computeCumulativeSum()’: Calculates and displays the cumulative sum of entered stock prices.
‘enterStockPrices(Scanner scanner)’: Allows the user to enter multiple stock prices.
StockPrice Class
Represents a single stock price with a ‘price’ field, a constructor to initialize it, a getter method for accessing the price, and a ‘toString’ method to return the stock price formatted to two decimal places.

# User Manual
# Getting Started
1. Running the Program: Ensure you have Java installed on your computer. Compile and run the ‘Main’ class using your IDE or the command line.
2. Navigating the Main Menu: Upon starting, the program displays a colorful main menu. Use the numbers 1-6 to select an option and press Enter.

# Using the Program
# Entering Stock Prices
Select option 1 from the main menu.
Enter prices separated by ';' and type 'end' when finished.

# Calculating the Average Price
Ensure you've entered stock prices first.
Select option 2 to display the average stock price.

# Finding the Maximum Stock Price
After entering prices, choose option 3.
Select the method (Array or ArrayList) for finding the maximum price.
    
# Counting Occurrences
Select option 4, enter the price you wish to count.

# Calculating Cumulative Sum
Choose option 5 after entering prices to see the cumulative sum.

# Exiting the Program
To exit, select option 6.

# Support
For any issues or queries, please refer to the documentation or contact support@filipal.com.
