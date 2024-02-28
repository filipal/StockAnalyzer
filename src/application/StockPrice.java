package application;

//This class represents a single stock price.
public class StockPrice {
    private double price; // Holds the value of the stock price.
    // Constructor to initialize the stock price with a specific value.
    public StockPrice(double price) {
        this.price = price;
    }
    // Getter method to access the private price field.
    public double getPrice() {
        return price;
    }
    // Overrides the toString method to return the stock price formatted to two decimal places.
    @Override
    public String toString() {
    	// Uses String.format to format the price.
        return String.format("%.2f", price);
    }
}

