Certainly! Here's an explanation of each line of code in the provided `StockUtils` class with comments:

```java
package Classes;

import Classes.Stock;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
```

These lines import necessary classes and packages required for the functionality of the `StockUtils` class.

```java
public class StockUtils {
    private static final String API_KEY1 = "ZK0GFWAKA82MSEC9";
    private static final String API_KEY2 = "FEVX5MOLAQB0H6NH"; // Education access 30 requests per minute
```

These lines define the `StockUtils` class and declare two `API_KEY` constants for accessing stock data. 
The second API key is specifically for educational purposes with a higher request limit.

```java
public static Stock searchStock(String input){
    input = input.trim();
    try {
        String[] symbol = getStockSymbol(input.toUpperCase(), API_KEY2);
        if (symbol == null) {
            System.out.println("Stock not found.");
            return null;
        }

        JSONObject stockData = getStockData(symbol[0], API_KEY2);
        if (stockData == null) {
            System.out.println("Error retrieving stock data. Please try again later. (limit 5 requests per minute)");
            return null;
        }

        return createStockInfo(stockData, symbol[1]);

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return null;
}
```

This method (`searchStock`) takes an `input` parameter, 
which represents the stock to search for. 
It trims the input, gets the stock symbol using `getStockSymbol` method, 
retrieves stock data using `getStockData` method, 
and creates a `Stock` object using `createStockInfo` method. 
It returns the created `Stock` object if successful; 
otherwise, it prints error messages and returns null.

```java
public static String[] getStockSymbol(String input, String apikey) throws IOException {
    String apiUrl = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + input +
            "&apikey=" + apikey;

    URL url = new URL(apiUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder response = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
        response.append(line);
    }
    reader.close();

    JSONObject jsonResponse = new JSONObject(response.toString());
    if (jsonResponse.has("bestMatches")) {
        JSONObject bestMatch = jsonResponse.getJSONArray("bestMatches").optJSONObject(0);
        if (bestMatch != null) {
            String symbol = bestMatch.getString("1. symbol");
            String name = bestMatch.getString("2. name");
            return new String[]{symbol, name};
        }
    }

    return null;
}
```

This method (`getStockSymbol`) takes an `input` parameter (stock symbol or name) and an `apikey` parameter. 
It constructs the API URL, 
makes an HTTP GET request to the Alpha Vantage API, 
retrieves the response, 
and parses the JSON response to extract the stock symbol and name. 
It returns an array of strings containing the symbol and name if a match is found; otherwise, 
it returns null.

```java
public static JSONObject getStockData(String symbol, String apiKey) throws IOException {
    String apiUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol +
            "&apikey=" + apiKey;

    URL url = new URL(apiUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder response = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
        response.append(line);
    }
    reader.close();

    JSONObject jsonResponse = new JSONObject(response.toString());
    if (jsonResponse.has("Global Quote")) {
        return jsonResponse.getJSONObject("Global Quote");
    }

    return null;
}
```

This method (`getStockData`) takes a `symbol` (stock symbol) and `apiKey` as parameters. 
It constructs the API URL for retrieving global quote data,
makes an HTTP GET request to the Alpha Vantage API, 
retrieves the response, 
and parses the JSON response to extract the global quote information. 
It returns a `JSONObject` containing the global quote data if available; 
otherwise, it returns null.

```java
private static Stock createStockInfo(JSONObject stockData, String name) {
    String symbol = stockData.getString("01. symbol");
    double price = stockData.getDouble("05. price");
    long volume = stockData.getLong("06. volume");
    double change = stockData.getDouble("09. change");
    String changePercentString = stockData.getString("10. change percent");
    double changePercent = Double.parseDouble(changePercentString.replace("%", ""));

    return new Stock(symbol, name, price, volume, change, changePercent);
}
```

This method (`createStockInfo`) takes a `stockData` `JSONObject` and a `name` parameter. 
It extracts specific data fields (symbol, price, volume, change, change percentage) from the `stockData` JSON object 
and creates a new `Stock` object with the extracted information. 
It returns the created `Stock` object.

```java
public static double getStockCurrentPrice(String stockSymbol) {
    try {
        String apiUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockSymbol +
                "&apikey=" + API_KEY2;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        if (jsonResponse.has("Global Quote")) {
            JSONObject stockData = jsonResponse.getJSONObject("Global Quote");
            return stockData.getDouble("05. price");
        }
    } catch (MalformedURLException e){
        System.out.println("Invalid URL: " + e.getMessage());
    } catch (IOException e) {
        System.out.println("Error retrieving stock price: " + e.getMessage());
    }

    return 0.0;
}
```

This method (`getStockCurrentPrice`) takes a `stockSymbol` parameter and retrieves the current price of the specified stock. 
It constructs the API URL for retrieving global quote data, 
makes an HTTP GET request to the Alpha Vantage API,
retrieves the response, 
and parses the JSON response to extract the current stock price. 
It returns the current stock price as a double value.

```java
public static List<Stock> scrapeStock() {
    List<Stock> stockData = new ArrayList<>();
    String url = "https://finance.yahoo.com/most-active?offset=0&count=50";

    try {
        // Send a GET request to the Yahoo Finance trending tickers page
        Document document = Jsoup.connect(url).get();

        // Find the table containing the stock data
        Element table = document.select("table").first();

        // Extract the stock data from the table
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements columns = row.select("td");
            String symbol = columns.get(0).text().trim();
            String name = columns.get(1).text().trim();
            String priceSt = columns.get(2).text().trim().replace(",", "");
            double price = parseDoubleValue(priceSt);
            String changeSt = columns.get(3).text().trim().replace("+", "");
            double change = parseDoubleValue(changeSt);
            String changePercentageSt = columns.get(4).text().trim().replace("%", "").replace("+", "");
            double changePercentage = parseDoubleValue(changePercentageSt);
            String volumeSt = columns.get(5).text().trim().replace(".", "").replace(",", "").replace("M", "000");
            long volume = parseLongValue(volumeSt);

            Stock stock = new Stock(symbol, name, price, volume, change, changePercentage);
            stockData.add(stock);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return stockData;
}
```

This method (`scrapeStock`) scrapes the stock data from the Yahoo Finance most active stocks page. 
It sends a GET request to the specified URL, 
retrieves the HTML document using Jsoup, 
and then extracts the stock data from the HTML table. 
It iterates over the table rows, extracts the symbol, name, price, change, change percentage, 
and volume values from the table cells, 
creates a `Stock` object with the extracted data, 
and adds it to the `stockData` list. 
Finally, it returns the list of `Stock` objects.

```java
private static double parseDoubleValue(String value) {
    if (value.equalsIgnoreCase("N/A")) {
        return 0.0; // Set a default value or handle it as needed
    }
    return Double.parseDouble(value);
}

private static long parseLongValue(String value) {
    if (value.equalsIgnoreCase("N/A")) {
        return 0L; // Set a default value or handle it as needed
    }
    return Long.parseLong(value);
}
```

These are helper methods (`parseDoubleValue` and `parseLongValue`) used to parse string values 
to their respective numerical types. 
They handle cases where the value is "N/A" by returning a default value 
(0.0 for `double` and 0L for `long`) 
or you can handle it as needed in your application.
