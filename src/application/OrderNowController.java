package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;

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

	int[] order;
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
		order = new int[spinnersList.size()];

		for (int i = 0; i < spinnersList.size(); i++) {
			order[i] = 0;
		}

	}

	private void updateOrder() {
		System.out.println(Arrays.toString(order));
		
	}

}