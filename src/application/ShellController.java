/**
 * 
 */
package application;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * @author bryan
 *
 */

public class ShellController extends AnchorPane {

	@FXML
	BorderPane mainPane;

	@FXML
	Text settingsNav;
	@FXML
	Text dashboardNav;
	@FXML
	Text logOutBtn;

	@FXML
	void initialize() {

		homeBtnListener();
	}

	@FXML
	public void homeBtnListener() {
		HomeController homeController = new HomeController();

		mainPane.setCenter(homeController);
	}

	@FXML
	public void menuBtnListener() {
		MenuController menuController = new MenuController();

		mainPane.setCenter(menuController);
	}

	@FXML
	public void nutritionBtnListener() {
		NutritionController nutritionController = new NutritionController();

		mainPane.setCenter(nutritionController);
	}

	@FXML
	public void couponBtnListener() {
		CouponController couponController = new CouponController();

		mainPane.setCenter(couponController);
	}

	@FXML
	public void orderNowBtnListener() {
		OrderNowController orderNowController = new OrderNowController();

		mainPane.setCenter(orderNowController);
	}

}
