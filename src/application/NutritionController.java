package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class NutritionController extends AnchorPane {
	
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

}
