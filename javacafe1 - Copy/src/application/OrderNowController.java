package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class OrderNowController extends AnchorPane {

	@FXML
	Spinner<Integer> americanoSpinner;

	@FXML
	Spinner<Integer> cappuccinoSpinner;

	@FXML
	Spinner<Integer> espressoSpinner;

	@FXML
	Spinner<Integer> hotChocolateSpinner;

	@FXML
	Spinner<Integer> whiteChocolateSpinner;

	@FXML
	Spinner<Integer> matchaLatteSpinner;

	@FXML
	Spinner<Integer> doughnutSpinner;

	@FXML
	Spinner<Integer> croissantSpinner;

	@FXML
	Spinner<Integer> cheesecakeSpinner;

	@FXML
	Text orderText;

	@FXML
	Text totalText;
	
	@FXML
	TextField couponTextField;
	
    @FXML
    Button couponButton;

	@FXML
	Button placeOrderButton;
	
	
	public boolean discount = false;
	int[] order;
	double orderTotal;
	String orderTextValue;
	ArrayList<Spinner<Integer>> spinnersList;

	public OrderNowController() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderNow.fxml"));

		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialize() {
		initSpinners();
		initOrder();

		placeOrderButton.setOnAction(placeOrderListener);
	}

	private void initSpinners() {

		spinnersList = new ArrayList<Spinner<Integer>>();

		spinnersList.add(americanoSpinner);
		spinnersList.add(cappuccinoSpinner);
		spinnersList.add(espressoSpinner);
		spinnersList.add(hotChocolateSpinner);
		spinnersList.add(whiteChocolateSpinner);
		spinnersList.add(matchaLatteSpinner);
		spinnersList.add(doughnutSpinner);
		spinnersList.add(croissantSpinner);
		spinnersList.add(cheesecakeSpinner);

		for (Spinner<Integer> spinner : spinnersList) {
			spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));

			spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
				order[spinnersList.indexOf(spinner)] = newValue;
				updateOrder();
			});
		}

	}

	private void initOrder() {
		orderTotal = 0;
		order = new int[spinnersList.size()];

		for (int i = 0; i < spinnersList.size(); i++) {
			order[i] = 0;
		}

	}

	private void updateOrder() {
		orderTotal = 0;
		orderTextValue = "";

		for (int i = 0; i < order.length; i++) {

			if (order[i] != 0) {
				int itemCount = order[i];
				switch (i) {
				case 0:
					orderTotal += itemCount * 3.25;
					orderTextValue += itemCount + "x Americano \n";
					break;
				case 1:
					orderTotal += itemCount * 3.75;
					orderTextValue += itemCount + "x Capuccino \n";
					break;
				case 2:
					orderTotal += itemCount * 3.50;
					orderTextValue += itemCount + "x Espresso \n";
					break;
				case 3:
					orderTotal += itemCount * 3.75;
					orderTextValue += itemCount + "x Hot Chocolate \n";
					break;
				case 4:
					orderTotal += itemCount * 3.75;
					orderTextValue += itemCount + "x White Chocolate \n";
					break;
				case 5:
					orderTotal += itemCount * 4.00;
					orderTextValue += itemCount + "x Matcha Latte \n";
					break;
				case 6:
					orderTotal += itemCount * 1.50;
					orderTextValue += itemCount + "x Doughnut \n";
					break;
				case 7:
					orderTotal += itemCount * 2.50;
					orderTextValue += itemCount + "x Croissant \n";
					break;
				case 8:
					orderTotal += itemCount * 4.75;
					orderTextValue += itemCount + "x Cheesecake \n";
					break;
				}
			}

		}
		
		
		
		

		orderText.setText(orderTextValue);
		totalText.setText("Total: $" + String.format("%.2f", orderTotal));
		
		if (discount == true) {
			orderTotal = orderTotal/2;
		}
		}
	
	
	private void resetOrder() {
		initSpinners();
		initOrder();
	}
	
	
	 @FXML
	    void ApplyCode(ActionEvent event) {
		 int code = Integer.parseInt(couponTextField.getText());
		 int Correct = 123;
	
		 if (code == Correct)
		 {
			 System.out.println("code applied");
			 discount = true;
			 
		 }
		 else 
		 {
			 System.out.println("bad");
		 }
		  
		
	    }

	EventHandler<ActionEvent> placeOrderListener = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			
			
			String orderReceipt = orderTextValue + "\n------------\nTotal: $" + String.format("%.2f", orderTotal);
			Alert alert = new Alert(AlertType.NONE, orderReceipt, ButtonType.OK);
			alert.setTitle("Java Cafe");
			if (discount = true) {
				alert.setHeaderText("Your Order Details With 50% Discount!");
			alert.showAndWait();
			
			if (alert.getResult() == ButtonType.OK) {
				resetOrder();
//				orderTextValue = "darn";
//				System.out.println("darn");
			}
			}
			else { 
				
			
			alert.setHeaderText("Your Order Details");
			alert.showAndWait();
			
			if (alert.getResult() == ButtonType.OK) {
				resetOrder();
//				orderTextValue = "darn";
//				System.out.println("darn");
			}
			}
		}
	};

}