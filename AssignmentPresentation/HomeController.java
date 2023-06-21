Sure! Here's the explanation for each part of the code in the `HomeController` class:

```java
public class HomeController implements Initializable {
```
The `HomeController` class is a controller for the home view in a JavaFX application.
    It implements the `Initializable` interface, 
    pwhich allows initializing the controller and its components when the associated FXML file is loaded.

```java
private User user;
public void setUser(User user){
    this.user = user;
}
```
This code defines a `User` object and a setter method `setUser()` to set the currently logged-in user.

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
These lines declare several buttons that are defined in the associated FXML file. The `@FXML` annotation is used to inject the buttons defined in the FXML into the controller.

```java
@FXML
private Label label_welcome;
@FXML
private Label label_date;
@FXML
private Label label_marketStatus;
```
These lines declare several labels that are defined in the associated FXML file. The `@FXML` annotation is used to inject the labels defined in the FXML into the controller.

```java
private Timeline timeline;
```
This declares a `Timeline` object that will be used to update the time and market status labels periodically.

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
These lines declare a `TableView` and several `TableColumn` objects used for displaying stock data. The `@FXML` annotation is used to inject them from the FXML file. The `popularStocks` list is populated with stock data using the `scrapeStock()` method from the `StockUtils` class.

```java
@Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    // ...
}
```
This is the initialization method that is called when the associated FXML file is loaded. It initializes the controller and sets up the initial state of the components.

```java
timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), event -> {
    updateDateTime();
    updateMarketStatus();
}));
timeline.setCycleCount(Timeline.INDEFINITE); // Run indefinitely
timeline.play();
```
This code creates a `Timeline` that updates the time and market status labels every second.
    It uses a `KeyFrame` with a duration of one second and 
    defines an event handler to call the `updateDateTime()` and `updateMarketStatus()` methods.

```java
btn_home.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Home.fxml", "Home", user));
btn_trade.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Trade.fxml", "Trade", user));
btn_leaderboard.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Leaderboard.fxml", "Leaderboard", user));
btn_profile.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Profile.fxml", "Profile", user));
btn_stockPrediction.setOnAction(event -> DBUtils.changeScene(event, "/FXML/StockPrediction.fxml", "Stock Prediction", user));
btn_setting.setOnAction(event -> DBUtils.changeScene(event, "/FXML/Setting.fxml", "Profile", user));
```
