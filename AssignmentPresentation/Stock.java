package Classes;  // Specifies that the class belongs to the package named "Classes"

public class Stock implements Comparable<Stock>{  // Defines the class named "Stock" and implements the Comparable interface with the generic type parameter of Stock

    private String symbol;  // Private member variable to store the symbol of the stock
    private String name;  // Private member variable to store the name of the stock
    private double price;  // Private member variable to store the price of the stock
    private long volume;  // Private member variable to store the volume of the stock
    private double change;  // Private member variable to store the change in the stock
    private double changePercent;  // Private member variable to store the change percentage of the stock


    public Stock(String symbol, String name, double price, long volume, double change, double changePercent) {
        // Constructor for initializing all the member variables of the Stock class
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.change = change;
        this.changePercent = changePercent;
    }

    public Stock(String symbol, String name, double price, long volume){
        // Constructor for initializing the symbol, name, price, and volume of the Stock class
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public Stock(String symbol){
        // Constructor for initializing only the symbol of the Stock class
        this.symbol = symbol;
    }

    public String getSymbol() {
        // Getter method to retrieve the symbol of the stock
        return symbol;
    }

    public String getName() {
        // Getter method to retrieve the name of the stock
        return name;
    }

    public double getPrice() {
        // Getter method to retrieve the price of the stock
        return price;
    }

    public void setPrice(double price) {
        // Setter method to set the price of the stock
        this.price = price;
    }

    public long getVolume() {
        // Getter method to retrieve the volume of the stock
        return volume;
    }

    public void setVolume(long volume) {
        // Setter method to set the volume of the stock
        this.volume = volume;
    }

    public double getChange() {
        // Getter method to retrieve the change in the stock
        return change;
    }

    public void setChange(double change) {
        // Setter method to set the change in the stock
        this.change = change;
    }

    public double getChangePercent() {
        // Getter method to retrieve the change percentage of the stock
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        // Setter method to set the change percentage of the stock
        this.changePercent = changePercent;
    }

    public Long updateStock(Order order){
        // Method to update the stock by subtracting the quantity of the order from the volume of the stock
        return getVolume() - order.getQuantity();
    }

    @Override
    public int compareTo(Stock other) {
        // Method to compare the volume of this stock with another stock for sorting purposes
        return Long.compare(this.volume, other.getVolume());
    }

    public String toString(){
        // Method to provide a string representation of the Stock object
        return "Stock{" +
                "\nStock ='" + symbol + '\'' +
                "\nQuantity =" + volume +
                "\nPrice =" + price +
                "\nChange =" + change +
                '}';
    }
}
