Certainly! Here's a detailed explanation for each line of code in the given JavaFX controller class:

```java
package Controllers;
```
This line specifies the package name for the controller class.

```java
import Classes.*;
import javafx.animation.*;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import org.jsoup.select.CombiningEvaluator;

import java.io.IOException;
import java.net.URL;
import java.time.*;
import java.time.format.*;
import java.util.*;
```
These lines import the required classes and packages for the controller's functionality.

```java
public class TradeController implements Initializable {
```
This line declares the class `TradeController` and specifies that it implements the `Initializable` interface.

```java
private User user;
public void setUser(User user){
    this.user = user;
    this.user.displayUserPortfolio();
    System.out.println("load user successful");
    label_balance.setText("$" + String.format("%.2f",user.getBalance()));
    label_profit.setText("$" + String.format("%.2f",user.getPnL()));
    label_loss.setText("" + String.format("%.2f",user.getPoint()));
}
```
These lines declare a private instance variable `user` of type `User` and define a setter method `setUser()` to set the user object. 
    Inside the `setUser()` method, the `user` instance variable is assigned the provided `User` object, 
    and some user-related information is displayed in labels.

```java
private TradingFunctions tf;
public void setTf(TradingFunctions tf){
    this.tf = tf;
}
```
These lines declare a private instance variable `tf` of type `TradingFunctions` 
    and define a setter method `setTf()` to set the `TradingFunctions` object.

```java
private Timeline timeline;
```
This line declares a private instance variable `timeline` of type `Timeline` 
    for updating the time and market status labels.

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
@FXML
private Label label_welcome;
@FXML
private Label label_date;
@FXML
private Label label_marketStatus;
@FXML
private Label label_companyName;
```
These lines annotate and declare various JavaFX UI components, such as buttons and labels, with `@FXML` annotations for use in the controller.

```java
@FXML
private Label label_stockCode;
@FXML
private Label label_volume;
@FXML
private Label label_price;
@FXML
private Label label_change;
@FXML
private TextField tf_searchBox;
@FXML
private Button btn_search;
```
These lines declare additional UI components related to stock information.

```java
@FXML
private ChoiceBox<String> cBox_action;
private String[] action = {"BUY", "SELL"};
```
These lines declare a choice box UI component and a string array containing the available actions (buy and sell).

```java
@FXML
private TextField tf_symbol;
@FXML
private TextField tf_price;
@FXML
private TextField tf_quantity;
@FXML
private Label label_totalPrice;
@FXML
private Button btn_calculate;
@FXML
private Button btn_executeTrade;
```
These lines declare UI components related to trade functionality, such as text fields and buttons.
