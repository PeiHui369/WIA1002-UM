Certainly! Let's go through each line of code in the `HomeController` class and explain what it does:

```java
private User user;
public void setUser(User user){
    this.user = user;
}
```

- These lines declare a private `User` object called `user` and define a public setter method `setUser` to set the value of `user`. This allows the `HomeController` to store information about the currently logged-in user.

```java
@FXML
private Button btn_setting;
@FXML
private Button btn_trade;
@FXML
private Button btn_home;
@FXML
private Button btn_leaderboard;
@FXML
private Button btn_profile;
@FXML
private Button btn_stockPrediction;
```

- These lines declare instance variables for several `Button` objects used in the user interface. The `@FXML` annotation is used to inject the buttons defined in the corresponding FXML file into these variables.

```java
@FXML
private Label label_welcome;
@FXML
private Label label_date;
@FXML
private Label label_marketStatus;
```

- Similar to the previous block, these lines declare instance variables for several `Label` objects used in the UI.

```java
private Timeline timeline;
```

- Declares a private `Timeline` object called `timeline` to store a timeline for updating the time and market status labels at regular intervals.

```java
@FXML
private TableView<Stock> table_displayStocks;
@FXML
private TableColumn<Stock, String> column_symbol;
@FXML
private TableColumn<Stock, String> column_name;
@FXML
private TableColumn<Stock, Double> column_price;
@FXML
private TableColumn<Stock, Double> column_change;
@FXML
private TableColumn<Stock, Double> column_changePercent;
@FXML
private TableColumn<Stock, Long> column_volume;
List<Stock> popularStocks = StockUtils.scrapeStock();
```

- These lines declare instance variables for a `TableView` and several `TableColumn` objects used to display stock data in the UI. The `@FXML` annotation injects the corresponding UI components from the FXML file. The `List<Stock> popularStocks` is initialized by calling the `scrapeStock` method from a `StockUtils` class, which presumably retrieves stock data.

```java
@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    // ...
}
```

- This is the `initialize` method, which is an implementation of the `Initializable` interface. It is called automatically when the FXML file is loaded and sets up the initial state of the UI components.

```java
timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), event -> {
    updateDateTime();
    updateMarketStatus();
}));
timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();
```

- This block creates a `Timeline` object named `timeline` that triggers an event every second. The event calls the `updateDateTime` and `updateMarketStatus` methods to update the time and market status labels. `Timeline.INDEFINITE` sets the timeline to run indefinitely, and `timeline.play()` starts the timeline.

```java
btn_home.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Home.fxml", "Home", user));
btn_trade.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Trade.fxml", "Trade", user));
btn_leaderboard.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Leaderboard.fxml", "Leaderboard", user));
btn_profile.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Profile.fxml", "Profile", user));
btn_stockPrediction.setOnAction(event -> DBUtils.changeScene(event, "/FXML/StockPrediction.fxml", "Stock Prediction", user));
btn_setting.setOnAction(event -> DBUtils.changeScene(event, "/FXML/

Setting.fxml", "Profile", user));
```

- These lines set the `onAction` event handlers for the buttons. When a button is clicked, the corresponding method from the `DBUtils` class is called to change the scene to a different FXML file.

```java
column_symbol.setCellValueFactory(new PropertyValueFactory<>("symbol"));
column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
column_volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
column_change.setCellValueFactory(new PropertyValueFactory<>("change"));
column_changePercent.setCellValueFactory(new PropertyValueFactory<>("changePercent"));
```

- These lines configure the `CellValueFactory` for each `TableColumn` to specify how to retrieve the data for each column from the `Stock` object. The `"symbol"`, `"name"`, etc., are the names of the corresponding properties in the `Stock` class.

```java
if (popularStocks != null) {
    table_displayStocks.getItems().addAll(popularStocks);
} else {
    System.out.println("Problem with displaying stocks");
}
```

- This block checks if the `popularStocks` list is not null. If it's not null, it adds all the elements from the `popularStocks` list to the `TableView` using the `getItems()` method. If it's null, it prints a message indicating a problem with displaying the stocks.

```java
public void setUserInformation(String username) {
    label_welcome.setText("WELCOME " + username);
    updateDateTime();
    updateMarketStatus();
    timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), event -> {
        updateDateTime();
        updateMarketStatus();
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
}
```

- This method sets the user information in the UI. It takes a `username` parameter, sets the welcome label text to include the username, and then updates the time and market status labels. It also creates and starts a new timeline for updating the labels every second.

```java
private void updateDateTime() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy  hh:mm:ss a");
    String formattedDateTime = now.format(formatter);
    label_date.setText(formattedDateTime);
}
```

- This method retrieves the current date and time using `LocalDateTime.now()`. It then formats the date and time using a `DateTimeFormatter` and updates the text of the `label_date` label.

```java
private void updateMarketStatus() {
    MarketTimer marketTimer = new MarketTimer();

    if (marketTimer.isMarketOpen()) {
        label_marketStatus.setText("Market Open");
        label_marketStatus.setTextFill(Color.GREEN);
    } else {
        label_marketStatus.setText("Market Closed");
        label_marketStatus.setTextFill(Color.RED);
    }
}
```

- This method creates a `MarketTimer` object and checks if the market is open using the `isMarketOpen()` method. Based on the market status, it sets the text and color of the `label_marketStatus` label to indicate whether the market is open or closed. Green is used for "Market Open" and red for "Market Closed".

That covers the explanation of each line of code in the `HomeController` class. Let me know if you have any further questions!
