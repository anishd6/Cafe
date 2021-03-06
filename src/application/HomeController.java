package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class HomeController extends AnchorPane {
	
	public HomeController() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));

		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
