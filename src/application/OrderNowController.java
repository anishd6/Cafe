package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class OrderNowController extends AnchorPane {
	
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

}
