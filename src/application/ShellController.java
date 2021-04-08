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

	public int currentPage;

	@FXML
	void initialize() {

		homeBtnListener();
	}

	@FXML
	public void homeBtnListener() {

		setCurrentPage(0);

		if (mainPane != null) {
			HomeController homeController = new HomeController();
			mainPane.setCenter(homeController);

		}
	}

	@FXML
	public void menuBtnListener() {

		setCurrentPage(1);

		if (mainPane != null) {
			MenuController menuController = new MenuController();
			mainPane.setCenter(menuController);
		}
	}

	@FXML
	public void nutritionBtnListener() {

		setCurrentPage(2);

		if (mainPane != null) {
			NutritionController nutritionController = new NutritionController();
			mainPane.setCenter(nutritionController);
		}
	}

	@FXML
	public void couponBtnListener() {
		CouponController couponController = new CouponController();

		setCurrentPage(3);

		if (mainPane != null)
			mainPane.setCenter(couponController);
	}

	@FXML
	public void orderNowBtnListener() {

		setCurrentPage(4);

		if (mainPane != null) {
			OrderNowController orderNowController = new OrderNowController();
			mainPane.setCenter(orderNowController);
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
