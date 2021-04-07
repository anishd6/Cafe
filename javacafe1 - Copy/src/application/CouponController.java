package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class CouponController extends AnchorPane {
	
	public CouponController() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coupon.fxml"));

		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
