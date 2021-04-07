package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MenuController extends AnchorPane {
	
	public MenuController() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));

		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
