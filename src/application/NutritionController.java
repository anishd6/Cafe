package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
	Text orderCaloriesText;

	@FXML
	Text orderCarbohydratesText;

	@FXML
	Text orderProteinText;

	@FXML
	Text orderFatText;

	@FXML
	Text dailyCaloriesText;

	@FXML
	Text dailyCarbohydratesText;

	@FXML
	Text dailyProteinText;

	@FXML
	Text dailyFatText;

	int[] order;

	int dailyCalories;
	int dailyProtein;
	int dailyCarbohydrates;
	int dailyFat;

	int orderCalories;
	int orderProtein;
	int orderCarbohydrates;
	int orderFat;

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
		orderCalories = 0;
		orderProtein = 0;
		orderCarbohydrates = 0;
		orderFat = 0;

		dailyCalories = 1800;
		dailyProtein = 150;
		dailyCarbohydrates = 210;
		dailyFat = 40;

		order = new int[spinnersList.size()];

		for (int i = 0; i < spinnersList.size(); i++) {
			order[i] = 0;
		}

		orderCaloriesText.setText("Calories: " + orderCalories);
		orderFatText.setText("Fat (G): " + orderFat);
		orderProteinText.setText("Protien (G): " + orderProtein);
		orderCarbohydratesText.setText("Carbohydrates (G): " + orderCarbohydrates);

		dailyCaloriesText.setText("Calories: " + (dailyCalories - orderCalories));
		dailyFatText.setText("Fat (G): " + (dailyFat - orderFat));
		dailyProteinText.setText("Protien (G): " + (dailyProtein - orderProtein));
		dailyCarbohydratesText.setText("Carbohydrates (G): " + (dailyCarbohydrates - orderCarbohydrates));

	}

	private void updateNutrition() {
		orderCalories = 0;
		orderProtein = 0;
		orderCarbohydrates = 0;
		orderFat = 0;

		dailyCalories = 1800;
		dailyProtein = 150;
		dailyCarbohydrates = 210;
		dailyFat = 40;

		for (int i = 0; i < order.length; i++) {

			if (order[i] != 0) {
				int itemCount = order[i];
				switch (i) {
				case 0:
					orderCalories += itemCount * 15;
					orderFat += itemCount * 0;
					orderProtein += itemCount * 1;
					orderCarbohydrates += 2;
					break;
				case 1:
					orderCalories += itemCount * 140;
					orderFat += itemCount * 5;
					orderProtein += itemCount * 9;
					orderCarbohydrates += 14;
					break;
				case 2:
					orderCalories += itemCount * 170;
					orderFat += itemCount * 9;
					orderProtein += itemCount * 9;
					orderCarbohydrates += 14;
					break;
				case 3:
					orderCalories += itemCount * 440;
					orderFat += itemCount * 19;
					orderProtein += itemCount * 15;
					orderCarbohydrates += 55;
					break;
				case 4:
					orderCalories += itemCount * 370;
					orderFat += itemCount * 16;
					orderProtein += itemCount * 14;
					orderCarbohydrates += 43;
					break;
				case 5:
					orderCalories += itemCount * 240;
					orderFat += itemCount * 7;
					orderProtein += itemCount * 12;
					orderCarbohydrates += 34;
					break;
				case 6:
					orderCalories += itemCount * 480;
					orderFat += itemCount * 27;
					orderProtein += itemCount * 5;
					orderCarbohydrates += 56;
					break;
				case 7:
					orderCalories += itemCount * 260;
					orderFat += itemCount * 15;
					orderProtein += itemCount * 5;
					orderCarbohydrates += 27;
					break;
				case 8:
					orderCalories += itemCount * 321;
					orderFat += itemCount * 23;
					orderProtein += itemCount * 6;
					orderCarbohydrates += 26;
					break;
				}
			}

		}

		orderCaloriesText.setText("Calories: " + orderCalories);
		orderFatText.setText("Fat (G): " + orderFat);
		orderProteinText.setText("Protien (G): " + orderProtein);
		orderCarbohydratesText.setText("Carbohydrates (G): " + orderCarbohydrates);

		dailyCalories -= orderCalories;
		dailyFat -= orderFat;
		dailyProtein -= orderProtein;
		dailyCarbohydrates -= orderCarbohydrates;

		dailyCaloriesText.setText("Calories: " + dailyCalories);
		dailyFatText.setText("Fat (G): " + dailyFat);
		dailyProteinText.setText("Protien (G): " + dailyProtein);
		dailyCarbohydratesText.setText("Carbohydrates (G): " + dailyCarbohydrates);

		dailyCaloriesText.setFill(dailyCalories < 0 ? Color.RED : Color.BLACK);
		dailyFatText.setFill(dailyFat < 0 ? Color.RED : Color.BLACK);
		dailyProteinText.setFill(dailyProtein < 0 ? Color.RED : Color.BLACK);
		dailyCarbohydratesText.setFill(dailyCarbohydrates < 0 ? Color.RED : Color.BLACK);

	}

}
