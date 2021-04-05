package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class NutritionController extends AnchorPane {

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
	Text caloriesText;

	@FXML
	Text carbohydratesText;

	@FXML
	Text proteinText;

	@FXML
	Text fatText;

	int[] order;
	int calories;
	int protein;
	int carbohydrates;
	int fat;

	ArrayList<Spinner<Integer>> spinnersList;

	public NutritionController() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Nutrition.fxml"));

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
		initNutrition();
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
				updateNutrition();
			});
		}

	}

	private void initNutrition() {
		calories = 0;
		order = new int[spinnersList.size()];

		for (int i = 0; i < spinnersList.size(); i++) {
			order[i] = 0;
		}

	}

	private void updateNutrition() {
		calories = 0;
		fat = 0;
		protein = 0;
		carbohydrates = 0;

		for (int i = 0; i < order.length; i++) {

			if (order[i] != 0) {
				int itemCount = order[i];
				switch (i) {
				case 0:
					calories += itemCount * 15;
					fat += itemCount * 0;
					protein += itemCount * 1;
					carbohydrates += 2;
					break;
				case 1:
					calories += itemCount * 140;
					fat += itemCount * 5;
					protein += itemCount * 9;
					carbohydrates += 14;
					break;
				case 2:
					calories += itemCount * 170;
					fat += itemCount * 9;
					protein += itemCount * 9;
					carbohydrates += 14;
					break;
				case 3:
					calories += itemCount * 440;
					fat += itemCount * 19;
					protein += itemCount * 15;
					carbohydrates += 55;
					break;
				case 4:
					calories += itemCount * 370;
					fat += itemCount * 16;
					protein += itemCount * 14;
					carbohydrates += 43;
					break;
				case 5:
					calories += itemCount * 240;
					fat += itemCount * 7;
					protein += itemCount * 12;
					carbohydrates += 34;
					break;
				case 6:
					calories += itemCount * 480;
					fat += itemCount * 27;
					protein += itemCount * 5;
					carbohydrates += 56;
					break;
				case 7:
					calories += itemCount * 260;
					fat += itemCount * 15;
					protein += itemCount * 5;
					carbohydrates += 27;
					break;
				case 8:
					calories += itemCount * 321;
					fat += itemCount * 23;
					protein += itemCount * 6;
					carbohydrates += 26;
					break;
				}
			}

		}

		caloriesText.setText("Calories: " + calories);
		fatText.setText("Fat (G): " + fat);
		proteinText.setText("Protien (G): " + protein);
		carbohydratesText.setText("Carbohydrates (G): " + carbohydrates);
	}

}
